package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

public interface UserInfoService {

    int insertUser(UserInfo userInfo);

    UserInfo searchUserByOpenId(String openId);

    int insertUserPhone(int userId,String phoneNumber);

    String getUserTypeByUserId(int userId);

    UserInfo getUserByUserId(int userId);

    int deleteUser(int userId);

    int updateUser(UserInfo userInfo);

}
