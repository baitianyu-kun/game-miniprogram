package com.hebeu.miniprogram.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSON;
import com.hebeu.miniprogram.config.WxMaConfiguration;
import com.hebeu.miniprogram.entity.LoginInfo;
import com.hebeu.miniprogram.entity.UserInfo;
import com.hebeu.miniprogram.security.UserSessionKeyContext;
import com.hebeu.miniprogram.security.WebSessionContext;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 登录接口
     */
    @GetMapping("/login")
    public String login(String appId, String code, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        final WxMaService wxService = WxMaConfiguration.getMaService(appId);
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            //把信息都存到后端整个的session中
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("openId", session.getOpenid());
            httpSession.setAttribute("unionId", session.getUnionid());
            httpSession.setAttribute("sessionKey", session.getSessionKey());
            //返回登录信息
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setOpenId(session.getOpenid());
            loginInfo.setUnionId(session.getUnionid());
            loginInfo.setSessionId(httpSession.getId());
            return JSON.toJSONString(loginInfo);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return e.toString();
        }
    }

    @GetMapping("/{sessionId}/logout")
    public String logout(@PathVariable String sessionId, HttpServletRequest request, HttpServletResponse response) {
        WebSessionContext webSessionContext = WebSessionContext.getInstance();
        HttpSession session = webSessionContext.getSession(sessionId);
        if (session != null) {
            session.invalidate();
            webSessionContext.delSession(session);
            return ServiceStatus.LOG_OUT_SUCCESS;
        } else
            return ServiceStatus.ALREADY_LOG_OUT;
    }

    @GetMapping("/login2")
    public String login2(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        return String.valueOf(httpSession.getId());
    }

    /**
     * 根据用户id获取用户信息
     */
    @GetMapping("/{sessionId}/get_user_by_id")
    public String getUserByUserId(int userId) {
        UserInfo userByUserId = userInfoService.getUserByUserId(userId);
        if (userByUserId != null)
            return JSON.toJSONString(userByUserId);
        else
            return ServiceStatus.GET_USER_BY_USER_ID_FAILED;
    }

    /**
     * 用户注销接口
     */
    @GetMapping("/{sessionId}/delete")
    public String delete(int userId) {
        if (userInfoService.deleteUser(userId) != 0) {
            return ServiceStatus.USER_DELETED_SUCCESS;
        } else {
            return ServiceStatus.USER_DELETED_FAILED;
        }
    }

    /**
     * 获取用户类型，具体类型在Type.class中
     */
    @GetMapping("/{sessionId}/get_user_type")
    public String getUserType(int userId) {
        String userTypeByUserId = userInfoService.getUserTypeByUserId(userId);
        if (userTypeByUserId != null)
            return userTypeByUserId;
        else
            return ServiceStatus.GET_USER_TYPE_FAILED;
    }

    /**
     * 获取当前手机已经登陆的用户信息接口
     */
    @GetMapping("/{sessionId}/get_now_user_info")
    public String info(String appId, String openId, String userType, String signature, String rawData, String encryptedData, String iv, @PathVariable String sessionId) {
        //从session中拿该session的sessionKey信息
        WebSessionContext webSessionContext = WebSessionContext.getInstance();
        HttpSession session = webSessionContext.getSession(sessionId);
        String sessionKey= (String) session.getAttribute("sessionKey");
        UserInfo findUserInfo = userInfoService.searchUserByOpenId(openId);
        if (findUserInfo != null) {
            //是否为新用户
            findUserInfo.setNew(false);
            return JSON.toJSONString(findUserInfo);
        } else {
            //不是新用户的话，解密用户信息
            final WxMaService wxService = WxMaConfiguration.getMaService(appId);
            if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
                return ServiceStatus.USER_CHECK_FAILED;
            }
            WxMaUserInfo tempUserInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
            UserInfo newUserInfo = new UserInfo();
            newUserInfo.setNew(true);
            newUserInfo.setAppid(appId);
            newUserInfo.setOpenId(openId);
            newUserInfo.setAvatarUrl(tempUserInfo.getAvatarUrl());
            newUserInfo.setCity(tempUserInfo.getCity());
            newUserInfo.setCountry(tempUserInfo.getCountry());
            newUserInfo.setGender(tempUserInfo.getGender());
            newUserInfo.setLanguage(tempUserInfo.getLanguage());
            newUserInfo.setNickName(tempUserInfo.getNickName());
            newUserInfo.setUserType(userType);
            newUserInfo.setProvince(tempUserInfo.getProvince());
            if (userInfoService.insertUser(newUserInfo) != 0)
                return JSON.toJSONString(newUserInfo);
            else
                return ServiceStatus.USER_INSERT_FAILED;
        }
    }

    /**
     * 用户添加手机号
     */
    @GetMapping("/{sessionId}/get_phone")
    public String getUserPhone(int userId, String phoneNumber) {
        if (userInfoService.insertUserPhone(userId, phoneNumber) != 0) {
            return ServiceStatus.UPDATE_PHONE_SUCCESS;
        } else {
            return ServiceStatus.UPDATE_PHONE_FAILED;
        }
    }


    /**
     * 获取用户绑定手机号信息
     */
    @GetMapping("/{sessionId}/phone")
    public String phone(String appId, String sessionKey, String signature,
                        String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appId);
        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return ServiceStatus.USER_CHECK_FAILED;
        }
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        return JSON.toJSONString(phoneNoInfo);
    }

    /**
     * 新的获取方式，但是仅针对已经认证过的用户
     */
    @GetMapping("/{sessionId}/new_phone")
    public String newphone(String appId, String code) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appId);
        try {
            return JsonUtils.toJson(wxService.getUserService().getNewPhoneNoInfo(code));
        } catch (Exception e) {
            return JSON.toJSONString(e);
        }
    }

}
