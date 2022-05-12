package com.hebeu.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.hebeu.miniprogram.entity.ResumeInfo;
import com.hebeu.miniprogram.service.ResumeInfoService;
import com.hebeu.miniprogram.status.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeInfoController {

    @Autowired
    private ResumeInfoService resumeInfoService;

    @GetMapping("/delete_resume_info")
    public String deleteResumeInfo(int resumeId) {
        int i = resumeInfoService.deleteResumeInfo(resumeId);
        if (i!=0)
            return ServiceStatus.DELETE_RESUME_INFO_SUCCESS;
        else
            return ServiceStatus.DELETE_RESUME_INFO_FAILED;
    }

    @GetMapping("/insert_resume_info")
    public String insertResumeInfo() {
        return null;
    }

    @GetMapping("/search_all_resume_info")
    public String searchAllResumeInfo(){
        List<ResumeInfo> resumeInfos = resumeInfoService.searchAllResumeInfo();
        if (resumeInfos!=null)
            return JSON.toJSONString(resumeInfos);
        else
            return ServiceStatus.SEARCH_ALL_RESUME_INFO_FAILED;
    }

    @GetMapping("/search_resume_info_by_user_id")
    public String searchResumeInfoByUserId(int userId){
        List<ResumeInfo> resumeInfos = resumeInfoService.searchResumeInfoByUserId(userId);
        if (resumeInfos!=null)
            return JSON.toJSONString(resumeInfos);
        else
            return ServiceStatus.SEARCH_RESUME_INFO_BY_USER_ID_FAILED;
    }

    @GetMapping("/search_resume_info_by_resume_id")
    public String searchResumeInfoByResumeId(int resumeId){
        ResumeInfo resumeInfo = resumeInfoService.searchResumeInfoByResumeId(resumeId);
        if (resumeInfo!=null)
            return JSON.toJSONString(resumeInfo);
        else
            return ServiceStatus.SEARCH_RESUME_INFO_BY_RESUME_ID_FAILED;
    }

    @GetMapping("/search_resume_info_by_recruit_id")
    public String searchResumeInfoByRecruitId(int recruitId){
        List<ResumeInfo> resumeInfos = resumeInfoService.searchResumeInfoByRecruitId(recruitId);
        if (resumeInfos!=null)
            return JSON.toJSONString(resumeInfos);
        else
            return ServiceStatus.SEARCH_RESUME_INFO_BY_RECRUIT_ID_FAILED;
    }

    @GetMapping("/update_resume_info_status")
    public String updateResumeInfoStatus(String resumeStatus, int resumeId){
        int i = resumeInfoService.updateResumeInfoStatus(resumeStatus, resumeId);
        if (i!=0)
            return ServiceStatus.UPDATE_RESUME_INFO_STATUS_SUCCESS;
        else
            return ServiceStatus.UPDATE_RESUME_INFO_STATUS_FAILED;
    }

    @GetMapping("/update_resume_info")
    public String updateResumeInfo(String JSON_resumeInfo){
        ResumeInfo resumeInfo=JSON.parseObject(JSON_resumeInfo,ResumeInfo.class);
        int i = resumeInfoService.updateResumeInfo(resumeInfo);
        if (i!=0)
            return ServiceStatus.UPDATE_RESUME_INFO_SUCCESS;
        else
            return ServiceStatus.UPDATE_RESUME_INFO_FAILED;
    }
}
