package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.UserInfo;
import com.hebeu.miniprogram.mapper.UserInfoMapper;
import com.hebeu.miniprogram.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insertUser(UserInfo userInfo) {
        return userInfoMapper.insertUser(userInfo);
    }

    @Override
    public UserInfo findUser(String openId) {
        return userInfoMapper.findUser(openId);
    }
}
