package com.hebeu.miniprogram.service;

import com.hebeu.miniprogram.entity.UserInfo;
import org.springframework.stereotype.Service;

public interface UserInfoService {

    int insertUser(UserInfo userInfo);

    UserInfo findUser(String openId);

}
