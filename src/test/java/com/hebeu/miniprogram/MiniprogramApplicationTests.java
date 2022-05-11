package com.hebeu.miniprogram;

import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import com.hebeu.miniprogram.service.UserInfoService;
import com.hebeu.miniprogram.utils.SqlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class MiniprogramApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void SqlUtilsTest(){
        SqlUtils.generateMybatisInsertSql("com.hebeu.miniprogram.entity.ResumeInfo","resume_info");
    }

    @Test
    void UserInfoServiceImplTest(){
        userInfoService.findUser("23");
    }

}
