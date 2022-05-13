package com.hebeu.miniprogram;

import com.hebeu.miniprogram.entity.UserInfo;
import com.hebeu.miniprogram.service.UserInfoService;
import com.hebeu.miniprogram.status.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void userInfoServiceTest() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserType(Type.PERSONAL);
//        userInfo.setProvince("hebei");
//        userInfo.setPhoneNumber("");
//        userInfo.setLanguage(Type.CHINESE_LANG);
//        userInfo.setCountry("China");
//        userInfo.setGender("boy");
//        userInfo.setCity("handan");
//        userInfo.setNickName("baitianyu");
//        userInfo.setAvatarUrl("photo_url");
//        userInfo.setAppid("12346");
//        userInfo.setNew(true);
//        for (int i=5555;i<5570;i++){
//            userInfo.setOpenId(String.valueOf(i));
//            System.err.println("insert_result="+userInfoService.insertUser(userInfo));
//        }
        System.err.println("find_user_by_open_id="+userInfoService.searchUserByOpenId("5555"));
//        System.err.println("get_user_type="+userInfoService.getUserTypeByUserId((int) userInfo.getUserId()));
//        System.err.println("insert_user_phone="+userInfoService.insertUserPhone((int) userInfo.getUserId(),"15932366827"));
//
//        userInfo.setUserId(8);
//        System.err.println("update_user=" + userInfoService.updateUser(userInfo));

//        System.err.println("delete_user="+userInfoService.deleteUser(8));
    }
}
