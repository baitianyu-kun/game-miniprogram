package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.UserInfo;
import org.springframework.stereotype.Service;

public interface UserInfoService {

    int insertUser(UserInfo userInfo);

    UserInfo findUser(String openId);

    int insertUserPhone(int userId,String phoneNumber);

    String getUserType(int userId);

}
