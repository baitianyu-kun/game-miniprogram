package com.hebeu.miniprogram.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.hebeu.miniprogram.aop.WebLog;
import com.hebeu.miniprogram.config.WxMaConfiguration;
import com.hebeu.miniprogram.entity.UserInfo;
import com.hebeu.miniprogram.service.UserInfoService;
import com.hebeu.miniprogram.status.ServiceStatus;
import com.hebeu.miniprogram.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class WxMaUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final UserInfoService userInfoService;

    public WxMaUserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    /**
     * 登陆接口
     */
    @GetMapping("/login")
    @WebLog(description = "login")
    public String login(String appid, String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return e.toString();
        }
    }

    /**
     * 先访问这个接口，当用户不存在的时候再去注册
     */
    @GetMapping("/existinfo")
    @WebLog(description = "existInfo")
    public String existInfo(String openid) {
        UserInfo userInfo = userInfoService.findUser(openid);
        if (userInfo == null) {
            return ServiceStatus.USER_NOT_EXIST;
        } else {
            return JsonUtils.toJson(userInfo);
        }
    }

    /**
     * 获取用户信息接口
     */
    @GetMapping("/registerinfo")
    public String info(String appid, String sessionKey,
                       String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return ServiceStatus.USER_CHECK_FAILED;
        }
        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
        return JsonUtils.toJson(userInfo);
    }

    /**
     * 获取用户绑定手机号信息
     */
    @GetMapping("/phone")
    public String phone(String appid, String sessionKey, String signature,
                        String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return ServiceStatus.USER_CHECK_FAILED;
        }
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        return JsonUtils.toJson(phoneNoInfo);
    }

    /**
     * 新的获取方式，但是仅针对已经认证过的用户
     */
    @GetMapping("/newphone")
    public String newphone(String appid, String code) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        try {
            return JsonUtils.toJson(wxService.getUserService().getNewPhoneNoInfo(code));
        } catch (Exception e) {
            return JsonUtils.toJson(e);
        }
    }

}
