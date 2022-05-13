package com.hebeu.miniprogram.serviceImpl;

import com.hebeu.miniprogram.entity.UserInfo;
import com.hebeu.miniprogram.mapper.UserInfoMapper;
import com.hebeu.miniprogram.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public int insertUser(UserInfo userInfo) {
        return userInfoMapper.insertUser(userInfo);
    }

    @Override
    public UserInfo searchUserByOpenId(String openId) {
        return userInfoMapper.getUserByOpenId(openId);
    }

    @Override
    public int insertUserPhone(int userId, String phoneNumber) {
        return userInfoMapper.insertUserPhone(userId, phoneNumber);
    }

    @Override
    public String getUserTypeByUserId(int userId) {
        return userInfoMapper.getUserTypeByUserId(userId);
    }

    @Override
    public UserInfo getUserByUserId(int userId) {
        return userInfoMapper.getUserByUserId(userId);
    }

    @Override
    public int deleteUser(int userId) {
        return userInfoMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return userInfoMapper.updateUser(userInfo);
    }


}
