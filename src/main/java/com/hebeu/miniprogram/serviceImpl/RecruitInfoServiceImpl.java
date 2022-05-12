package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.mapper.RecruitInfoMapper;
import com.hebeu.miniprogram.service.RecruitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RecruitInfoServiceImpl implements RecruitInfoService {

    @Autowired
    private RecruitInfoMapper recruitInfoMapper;

    @Override
    public List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName) {
        return recruitInfoMapper.searchRecruitByEnterpriseName(enterpriseName);
    }

    @Override
    public int insertRecruitInfo(RecruitInfo recruitInfo) {
        // TODO
        return 0;
    }

    @Override
    public List<RecruitInfo> searchAllRecruit() {
        return recruitInfoMapper.searchAllRecruit();
    }

    @Override
    public List<RecruitInfo> searchRecruitByRecruitType(String recruitType) {
        return recruitInfoMapper.searchRecruitByRecruitType(recruitType);
    }

    @Override
    public List<RecruitInfo> searchRecruitByRecruitPosition(String recruitPosition) {
        return recruitInfoMapper.searchRecruitByRecruitPosition(recruitPosition);
    }

    @Override
    public List<RecruitInfo> searchRecruitByWorkLocation(String workLocation) {
        return recruitInfoMapper.searchRecruitByWorkLocation(workLocation);
    }

    @Override
    public List<RecruitInfo> searchRecruitByWorkPayment(String workPayment) {
        return recruitInfoMapper.searchRecruitByWorkPayment(workPayment);
    }

    @Override
    public List<RecruitInfo> searchRecruitByWorkPeriod(String workPeriod) {
        return recruitInfoMapper.searchRecruitByWorkPeriod(workPeriod);
    }

    @Override
    public List<RecruitInfo> searchRecruitByWorkType(String workType) {
        return recruitInfoMapper.searchRecruitByWorkType(workType);
    }

    @Override
    public List<RecruitInfo> searchRecruitByReleaseTime(String beginTime, String endTime) {
        return recruitInfoMapper.searchRecruitByReleaseTime(beginTime, endTime);
    }
}
