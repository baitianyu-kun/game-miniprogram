package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.mapper.EnterpriseInfoMapper;
import com.hebeu.miniprogram.mapper.RecruitInfoMapper;
import com.hebeu.miniprogram.mapper.UserInfoMapper;
import com.hebeu.miniprogram.service.RecruitInfoService;
import com.hebeu.miniprogram.status.Type;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RecruitInfoServiceImpl implements RecruitInfoService {

    @Autowired
    private RecruitInfoMapper recruitInfoMapper;

    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName) {
        return recruitInfoMapper.searchRecruitByEnterpriseName(enterpriseName);
    }

    @Override
    public int insertRecruitInfo(RecruitInfo recruitInfo) {
        //是个人用户的话,就没有企业信息
        if (userInfoMapper.getUserType((int) recruitInfo.getUserId()).equals(Type.PERSONAL)) {
            return recruitInfoMapper.insertRecruitInfo(recruitInfo);
        } else {
            if (enterpriseInfoMapper.insertEnterpriseInfo(recruitInfo.getEnterpriseInfo()) != 0) {
                recruitInfo.setEnterpriseId(recruitInfo.getEnterpriseInfo().getEnterpriseId());
                return recruitInfoMapper.insertRecruitInfo(recruitInfo);
            } else {
                return 0;
            }
        }
    }

    @Override
    public int updateRecruitInfo(RecruitInfo recruitInfo) {
        return recruitInfoMapper.updateRecruitInfo(recruitInfo);
    }

    @Override
    public int deleteRecruitInfo(int recruitId) {
        return recruitInfoMapper.deleteRecruitInfo(recruitId);
    }

    @Override
    public List<RecruitInfo> searchAllRecruit() {
        return recruitInfoMapper.searchAllRecruit();
    }

    @Override
    public RecruitInfo searchRecruitByRecruitId(int recruitId) {
        return recruitInfoMapper.searchRecruitByRecruitId(recruitId);
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

    @Override
    public List<RecruitInfo> searchRecruitByUserId(int userId) {
        return recruitInfoMapper.searchRecruitByUserId(userId);
    }
}
