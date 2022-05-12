package com.hebeu.miniprogram.controller;

import com.alibaba.fastjson.JSON;
import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import com.hebeu.miniprogram.service.ExpectedJobInfoService;
import com.hebeu.miniprogram.status.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expect")
public class ExpectedJobInfoController {

    @Autowired
    private ExpectedJobInfoService expectedJobInfoService;

    @GetMapping("/insert_expected_job_info")
    public String insertExpectedJobInfo(String JSON_expectedJobInfo) {
        ExpectedJobInfo expectedJobInfo = JSON.parseObject(JSON_expectedJobInfo, ExpectedJobInfo.class);
        int i = expectedJobInfoService.insertExpectedJobInfo(expectedJobInfo);
        if (i != 0)
            return ServiceStatus.INSERT_EXPECTED_JOB_INFO_SUCCESS;
        else
            return ServiceStatus.INSERT_EXPECTED_JOB_INFO_FAILED;
    }

    @GetMapping("/delete_expected_job_info")
    public String deleteExpectedJobInfo(int expectedId) {
        int i = expectedJobInfoService.deleteExpectedJobInfo(expectedId);
        if (i != 0)
            return ServiceStatus.DELETE_EXPECTED_JOB_INFO_SUCCESS;
        else
            return ServiceStatus.DELETE_EXPECTED_JOB_INFO_FAILED;
    }

    @GetMapping("/search_all_expected_job_info")
    public String searchAllExpectedJobInfo() {
        List<ExpectedJobInfo> expectedJobInfos = expectedJobInfoService.searchAllExpectedJobInfo();
        if (expectedJobInfos != null)
            return JSON.toJSONString(expectedJobInfos);
        else
            return ServiceStatus.SEARCH_ALL_EXPECTED_JOB_INFO_FAILED;
    }

    @GetMapping("/search_expected_job_info_by_user_id")
    public String searchExpectedJobInfoByUserId(int userId) {
        List<ExpectedJobInfo> expectedJobInfos = expectedJobInfoService.searchExpectedJobInfoByUserId(userId);
        if (expectedJobInfos != null)
            return JSON.toJSONString(expectedJobInfos);
        else
            return ServiceStatus.SEARCH_EXPECTED_JOB_INFO_BY_USER_ID;
    }

    @GetMapping("/update_expected_job_info")
    public String updateExpectedJobInfo(String JSON_expectedJobInfo) {
        ExpectedJobInfo expectedJobInfo = JSON.parseObject(JSON_expectedJobInfo, ExpectedJobInfo.class);
        int i = expectedJobInfoService.updateExpectedJobInfo(expectedJobInfo);
        if (i != 0)
            return ServiceStatus.UPDATE_EXPECTED_JOB_INFO_SUCCESS;
        else
            return ServiceStatus.UPDATE_EXPECTED_JOB_INFO_FAILED;
    }


}
