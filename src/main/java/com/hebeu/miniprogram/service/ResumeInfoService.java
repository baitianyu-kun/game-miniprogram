package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.ResumeInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ResumeInfoService {

    int insertResumeInfo(ResumeInfo resumeInfo);

    int deleteResumeInfo(int resumeId);

    List<ResumeInfo> searchAllResumeInfo();

    List<ResumeInfo> searchResumeInfoByUserId(int userId);

    ResumeInfo searchResumeInfoByResumeId(int resumeId);

    //根据某个岗位查找所有简历
    List<ResumeInfo> searchResumeInfoByRecruitId(int recruitId);

    //更新简历状态信息
    int updateResumeInfoStatus(String resumeStatus, int resumeId);

    //更新简历信息
    int updateResumeInfo(ResumeInfo resumeInfo);

}
