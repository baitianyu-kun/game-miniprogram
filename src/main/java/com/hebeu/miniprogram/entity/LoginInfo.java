package com.hebeu.miniprogram.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginInfo {


    private String openId;

    private String unionId;

    private String sessionId;

}
