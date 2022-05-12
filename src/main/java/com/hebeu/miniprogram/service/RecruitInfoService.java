package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.RecruitInfo;

import java.util.List;

public interface RecruitInfoService {
    List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName);
}
