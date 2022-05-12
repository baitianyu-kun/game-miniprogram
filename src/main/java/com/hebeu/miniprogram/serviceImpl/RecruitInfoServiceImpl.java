package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.mapper.RecruitInfoMapper;
import com.hebeu.miniprogram.service.RecruitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitInfoServiceImpl implements RecruitInfoService {

    @Autowired
    private RecruitInfoMapper recruitInfoMapper;

    @Override
    public List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName) {
        return recruitInfoMapper.searchRecruitByEnterpriseName(enterpriseName);
    }
}
