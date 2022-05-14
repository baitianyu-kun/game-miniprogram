package com.hebeu.miniprogram.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.constant.WxMaConstants;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.api.R;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.hebeu.miniprogram.aop.WebLog;
import com.hebeu.miniprogram.config.WxMaConfiguration;
import com.hebeu.miniprogram.entity.ResumeInfo;
import com.hebeu.miniprogram.service.ResumeInfoService;
import com.hebeu.miniprogram.status.ServiceStatus;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/{sessionId}/{userId}/resume")
public class ResumeInfoController {

    @Autowired
    private ResumeInfoService resumeInfoService;

    /**
     *删除简历信息
     */
    @GetMapping("/delete_resume_info")
    public String deleteResumeInfo(int resumeId) {
        int i = resumeInfoService.deleteResumeInfo(resumeId);
        if (i != 0)
            return ServiceStatus.DELETE_RESUME_INFO_SUCCESS;
        else
            return ServiceStatus.DELETE_RESUME_INFO_FAILED;
    }

    /**
     *插入简历信息
     */
    @GetMapping("/insert_resume_info")
    public List<String> insertResumeInfo(@PathVariable String appid, HttpServletRequest request, @PathVariable int userId, int recruit_id) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (!resolver.isMultipart(request)) {
            return Lists.newArrayList();
        }
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> it = multiRequest.getFileNames();
        List<String> result = Lists.newArrayList();
        while (it.hasNext()) {
            try {
                MultipartFile file = multiRequest.getFile(it.next());
                File newFile = new File(Files.createTempDir(), file.getOriginalFilename());
                file.transferTo(newFile);
                ResumeInfo resumeInfo = new ResumeInfo();
                resumeInfo.setUserId(userId);
                resumeInfo.setResumeStatus(ServiceStatus.RESUME_POSTED);
                resumeInfo.setResumeFileUrl(newFile.toString());
                resumeInfo.setRecruitId(recruit_id);
                resumeInfoService.insertResumeInfo(resumeInfo);
                WxMediaUploadResult uploadResult = wxService.getMediaService().uploadMedia(WxMaConstants.KefuMsgType.IMAGE, newFile);
                result.add(uploadResult.getMediaId());
            } catch (IOException | WxErrorException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     *获取所有简历信息
     */
    @GetMapping("/search_all_resume_info")
    public String searchAllResumeInfo() {
        List<ResumeInfo> resumeInfos = resumeInfoService.searchAllResumeInfo();
        if (resumeInfos != null)
            return JSON.toJSONString(resumeInfos);
        else
            return ServiceStatus.SEARCH_ALL_RESUME_INFO_FAILED;
    }

    /**
     *获取该用户所发表的所有简历信息
     */
    @GetMapping("/search_resume_info_by_user_id")
    public String searchResumeInfoByUserId(@PathVariable int userId) {
        List<ResumeInfo> resumeInfos = resumeInfoService.searchResumeInfoByUserId(userId);
        if (resumeInfos != null)
            return JSON.toJSONString(resumeInfos);
        else
            return ServiceStatus.SEARCH_RESUME_INFO_BY_USER_ID_FAILED;
    }

    /**
     *根据简历id搜寻简历
     */
    @GetMapping("/search_resume_info_by_resume_id")
    public String searchResumeInfoByResumeId(int resumeId) {
        ResumeInfo resumeInfo = resumeInfoService.searchResumeInfoByResumeId(resumeId);
        if (resumeInfo != null)
            return JSON.toJSONString(resumeInfo);
        else
            return ServiceStatus.SEARCH_RESUME_INFO_BY_RESUME_ID_FAILED;
    }

    /**
     *获取所有投递到这个岗位的简历
     */
    @GetMapping("/search_resume_info_by_recruit_id")
    public String searchResumeInfoByRecruitId(int recruitId) {
        List<ResumeInfo> resumeInfos = resumeInfoService.searchResumeInfoByRecruitId(recruitId);
        if (resumeInfos != null)
            return JSON.toJSONString(resumeInfos);
        else
            return ServiceStatus.SEARCH_RESUME_INFO_BY_RECRUIT_ID_FAILED;
    }

    /**
     *更新简历状态
     */
    @GetMapping("/update_resume_info_status")
    public String updateResumeInfoStatus(String resumeStatus, int resumeId) {
        int i = resumeInfoService.updateResumeInfoStatus(resumeStatus, resumeId);
        if (i != 0)
            return ServiceStatus.UPDATE_RESUME_INFO_STATUS_SUCCESS;
        else
            return ServiceStatus.UPDATE_RESUME_INFO_STATUS_FAILED;
    }

    /**
     *更新简历信息
     */
    @GetMapping("/update_resume_info")
    public String updateResumeInfo(String JSON_resumeInfo) {
        ResumeInfo resumeInfo = JSON.parseObject(JSON_resumeInfo, ResumeInfo.class);
        int i = resumeInfoService.updateResumeInfo(resumeInfo);
        if (i != 0)
            return ServiceStatus.UPDATE_RESUME_INFO_SUCCESS;
        else
            return ServiceStatus.UPDATE_RESUME_INFO_FAILED;
    }
}
