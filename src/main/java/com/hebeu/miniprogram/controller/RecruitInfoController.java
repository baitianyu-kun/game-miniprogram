package com.hebeu.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.service.RecruitInfoService;
import com.hebeu.miniprogram.status.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/{appId}/{openId}/{userId}/recruit")
public class RecruitInfoController {

    @Autowired
    private RecruitInfoService recruitInfoService;

    /**
     *插入招聘信息
     */
    @GetMapping("/insert_recruit_info")
    public String insertRecruitInfo(String JSON_RecruitInfo) {
        RecruitInfo recruitInfo = JSON.parseObject(JSON_RecruitInfo, RecruitInfo.class);
        if (recruitInfoService.insertRecruitInfo(recruitInfo) != 0) {
            return ServiceStatus.INSERT_RECRUIT_INFO_SUCCESS;
        } else {
            return ServiceStatus.INSERT_RECRUIT_INFO_FAILED;
        }
    }

    @GetMapping("/search_recruit_by_enterprise_name")
    public String searchRecruitByEnterpriseName(String enterpriseName) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByEnterpriseName("%" + enterpriseName + "%");
        if (recruitInfos != null) {
            return JSON.toJSONString(recruitInfos);
        } else {
            return ServiceStatus.SEARCH_RECRUIT_BY_ENTERPRISE_NAME_FAILED;
        }
    }

    @GetMapping("/update_recruit_info")
    public String updateRecruitInfo(RecruitInfo recruitInfo) {
        int i = recruitInfoService.updateRecruitInfo(recruitInfo);
        if (i != 0)
            return ServiceStatus.UPDATE_RECRUIT_INFO_SUCCESS;
        else
            return ServiceStatus.UPDATE_RECRUIT_INFO_FAILED;
    }

    @GetMapping("/delete_recruit_info")
    public String deleteRecruitInfo(int recruitId) {
        int i = recruitInfoService.deleteRecruitInfo(recruitId);
        if (i != 0)
            return ServiceStatus.DELETE_RECRUIT_INFO_SUCCESS;
        else
            return ServiceStatus.DELETE_RECRUIT_INFO_FAILED;
    }

    @GetMapping("/search_all_recruit")
    public String searchAllRecruit() {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchAllRecruit();
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_ALL_RECRUIT_FAILED;
    }

    @GetMapping("/search_recruit_by_recruit_id")
    public String searchRecruitByRecruitId(int recruitId) {
        RecruitInfo recruitInfo = recruitInfoService.searchRecruitByRecruitId(recruitId);
        if (recruitInfo != null)
            return JSON.toJSONString(recruitInfo);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_RECRUIT_ID_FAILED;
    }

    @GetMapping("/search_recruit_by_recruit_type")
    public String searchRecruitByRecruitType(String recruitType) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByRecruitType(recruitType);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_RECRUIT_TYPE_FAILED;
    }

    @GetMapping("/search_recruit_by_recruit_position")
    public String searchRecruitByRecruitPosition(String recruitPosition) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByRecruitPosition(recruitPosition);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_RECRUIT_POSITION_FAILED;
    }

    @GetMapping("/search_recruit_by_work_location")
    public String searchRecruitByWorkLocation(String workLocation) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByWorkLocation(workLocation);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_WORK_LOCATION_FAILED;
    }

    @GetMapping("/search_recruit_by_work_payment")
    public String searchRecruitByWorkPayment(String workPayment) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByWorkPayment(workPayment);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_WORK_PAYMENT_FAILED;
    }

    @GetMapping("/search_recruit_by_work_period")
    public String searchRecruitByWorkPeriod(String workPeriod) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByWorkPeriod(workPeriod);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_WORK_PERIOD_FAILED;
    }

    @GetMapping("/search_recruit_by_work_type")
    public String searchRecruitByWorkType(String workType) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByWorkType(workType);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_WORK_TYPE_FAILED;
    }

    @GetMapping("/search_recruit_by_release_time")
    public String searchRecruitByReleaseTime(String beginTime, String endTime) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByReleaseTime(beginTime, endTime);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_RELEASE_TIME_FAILED;
    }

    @GetMapping("/search_recruit_by_user_id")
    public String searchRecruitByUserId(@PathVariable int userId) {
        List<RecruitInfo> recruitInfos = recruitInfoService.searchRecruitByUserId(userId);
        if (recruitInfos != null)
            return JSON.toJSONString(recruitInfos);
        else
            return ServiceStatus.SEARCH_RECRUIT_BY_USER_ID_FAILED;
    }

}
