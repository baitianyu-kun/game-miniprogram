package com.hebeu.miniprogram.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private long userId;
    private String userType;
    private String phoneNumber;
    private String avatarUrl;
    private String nickName;
    private String gender;
    private String language;
    private String country;
    private String province;
    private String city;
    private String appid;
    private String openId;
    private boolean isNew;

}
