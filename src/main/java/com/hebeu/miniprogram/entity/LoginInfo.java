package com.hebeu.miniprogram.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginInfo {

    private String sessionKey;

    private String openid;

    private String unionid;

    private String sessionId;

}
