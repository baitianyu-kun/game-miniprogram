package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.RecruitInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecruitInfoService {

    List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName);

    int insertRecruitInfo(RecruitInfo recruitInfo);

    List<RecruitInfo> searchAllRecruit();

    List<RecruitInfo> searchRecruitByRecruitType(String recruitType);

    List<RecruitInfo> searchRecruitByRecruitPosition(String recruitPosition);

    List<RecruitInfo> searchRecruitByWorkLocation(String workLocation);

    List<RecruitInfo> searchRecruitByWorkPayment(String workPayment);

    List<RecruitInfo> searchRecruitByWorkPeriod(String workPeriod);

    List<RecruitInfo> searchRecruitByWorkType(String workType);

    List<RecruitInfo> searchRecruitByReleaseTime(String beginTime,String endTime);
}
