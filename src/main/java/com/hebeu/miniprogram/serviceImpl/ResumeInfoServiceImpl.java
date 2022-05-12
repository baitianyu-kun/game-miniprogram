package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.ResumeInfo;
import com.hebeu.miniprogram.service.ResumeInfoService;

import java.util.List;

public class ResumeInfoServiceImpl implements ResumeInfoService {
    @Override
    public int insertResumeInfo(ResumeInfo resumeInfo) {
        return 0;
    }

    @Override
    public int deleteResumeInfo(int resumeId) {
        return 0;
    }

    @Override
    public List<ResumeInfo> searchAllResumeInfo() {
        return null;
    }

    @Override
    public List<ResumeInfo> searchResumeInfoByUserId(int userId) {
        return null;
    }

    @Override
    public ResumeInfo searchResumeInfoByResumeId(int resumeId) {
        return null;
    }

    @Override
    public List<ResumeInfo> searchResumeInfoByRecruitId(int recruitId) {
        return null;
    }

    @Override
    public int updateResumeInfoStatus(String resumeStatus, int resumeId) {
        return 0;
    }

    @Override
    public int updateResumeInfo(ResumeInfo resumeInfo) {
        return 0;
    }
}
