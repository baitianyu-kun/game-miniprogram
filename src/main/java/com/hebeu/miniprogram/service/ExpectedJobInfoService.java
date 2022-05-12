package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.ExpectedJobInfo;

import java.util.List;

public interface ExpectedJobInfoService {

    int insertExpectedJobInfo(ExpectedJobInfo expectedJobInfo);

    int deleteExpectedJobInfo(int expectedId);

    List<ExpectedJobInfo> searchAllExpectedJobInfo();

    List<ExpectedJobInfo> searchExpectedJobInfoByUserId(int userId);

    int updateExpectedJobInfo(ExpectedJobInfo expectedJobInfo);
}
