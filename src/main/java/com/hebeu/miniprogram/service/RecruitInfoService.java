package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.RecruitInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecruitInfoService {

    int insertRecruitInfo(RecruitInfo recruitInfo);

    //修改招聘信息不可修改recruit id，user id和enterprise id
    int updateRecruitInfo(RecruitInfo recruitInfo);

    int deleteRecruitInfo(int recruitId);

    List<RecruitInfo> searchAllRecruit();

    RecruitInfo searchRecruitByRecruitId(int recruitId);

    List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName);

    List<RecruitInfo> searchRecruitByRecruitType(String recruitType);

    List<RecruitInfo> searchRecruitByRecruitPosition(String recruitPosition);

    List<RecruitInfo> searchRecruitByWorkLocation(String workLocation);

    List<RecruitInfo> searchRecruitByWorkPayment(String workPayment);

    List<RecruitInfo> searchRecruitByWorkPeriod(String workPeriod);

    List<RecruitInfo> searchRecruitByWorkType(String workType);

    // "2015-01-01 13:50:42", "2023-02-06 00:00:00"
    List<RecruitInfo> searchRecruitByReleaseTime(String beginTime, String endTime);

    // 根据用户id来找其发表过的所有招聘信息
    List<RecruitInfo> searchRecruitByUserId(int userId);
}
