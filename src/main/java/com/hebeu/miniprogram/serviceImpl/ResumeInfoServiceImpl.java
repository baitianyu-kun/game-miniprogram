package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.ResumeInfo;
import com.hebeu.miniprogram.mapper.ResumeInfoMapper;
import com.hebeu.miniprogram.service.ResumeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeInfoServiceImpl implements ResumeInfoService {

    @Autowired
    private ResumeInfoMapper resumeInfoMapper;

    @Override
    public int insertResumeInfo(ResumeInfo resumeInfo) {
        return resumeInfoMapper.insertResumeInfo(resumeInfo);
    }

    @Override
    public int deleteResumeInfo(int resumeId) {
        return resumeInfoMapper.deleteResumeInfo(resumeId);
    }

    @Override
    public List<ResumeInfo> searchAllResumeInfo() {
        return resumeInfoMapper.searchAllResumeInfo();
    }

    @Override
    public List<ResumeInfo> searchResumeInfoByUserId(int userId) {
        return resumeInfoMapper.searchResumeInfoByUserId(userId);
    }

    @Override
    public ResumeInfo searchResumeInfoByResumeId(int resumeId) {
        return resumeInfoMapper.searchResumeInfoByResumeId(resumeId);
    }

    @Override
    public List<ResumeInfo> searchResumeInfoByRecruitId(int recruitId) {
        return resumeInfoMapper.searchResumeInfoByRecruitId(recruitId);
    }

    @Override
    public int updateResumeInfoStatus(String resumeStatus, int resumeId) {
        return resumeInfoMapper.updateResumeInfoStatus(resumeStatus,resumeId);
    }

    @Override
    public int updateResumeInfo(ResumeInfo resumeInfo) {
        return resumeInfoMapper.updateResumeInfo(resumeInfo);
    }
}
