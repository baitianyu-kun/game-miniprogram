package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import com.hebeu.miniprogram.mapper.ExpectedJobInfoMapper;
import com.hebeu.miniprogram.service.ExpectedJobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpectedJobInfoServiceImpl implements ExpectedJobInfoService {

    @Autowired
    private ExpectedJobInfoMapper expectedJobInfoMapper;

    @Override
    public int insertExpectedJobInfo(ExpectedJobInfo expectedJobInfo) {
        return expectedJobInfoMapper.insertExpectedJobInfo(expectedJobInfo);
    }

    @Override
    public int deleteExpectedJobInfo(int expectedId) {
        return expectedJobInfoMapper.deleteExpectedJobInfo(expectedId);
    }

    @Override
    public List<ExpectedJobInfo> searchAllExpectedJobInfo() {
        return expectedJobInfoMapper.searchAllExpectedJobInfo();
    }

    @Override
    public List<ExpectedJobInfo> searchExpectedJobInfoByUserId(int userId) {
        return expectedJobInfoMapper.searchExpectedJobInfoByUserId(userId);
    }

    @Override
    public int updateExpectedJobInfo(ExpectedJobInfo expectedJobInfo) {
        return expectedJobInfoMapper.updateExpectedJobInfo(expectedJobInfo);
    }
}
