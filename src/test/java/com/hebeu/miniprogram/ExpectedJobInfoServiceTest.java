package com.hebeu.miniprogram;

import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import com.hebeu.miniprogram.service.ExpectedJobInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class ExpectedJobInfoServiceTest {

    @Autowired
    private ExpectedJobInfoService expectedJobInfoService;

    @Test
    void expectedJobInfoServiceTest(){
        for (int userid=1;userid<=15;userid++){
            ExpectedJobInfo expectedJobInfo=new ExpectedJobInfo();
            expectedJobInfo.setUserId(userid);
            expectedJobInfo.setReleaseTime(new Timestamp(System.currentTimeMillis()));
            expectedJobInfo.setContactInfo("15932366827");
            expectedJobInfo.setWorkContent("work content");
            expectedJobInfo.setWorkLocation("handan");
            expectedJobInfo.setWorkPayment("1500");
            expectedJobInfo.setWorkPeriod("1-5");
            expectedJobInfo.setWorkTime("15h");
            expectedJobInfo.setWorkType("computer");
            System.err.println("expected_insert_result="+expectedJobInfoService.insertExpectedJobInfo(expectedJobInfo));
        }

        System.err.println("searchAllExpectedJobInfo="+expectedJobInfoService.searchAllExpectedJobInfo());
        System.err.println("searchExpectedJobInfoByUserId(2)"+expectedJobInfoService.searchExpectedJobInfoByUserId(2));

        ExpectedJobInfo expectedJobInfo=new ExpectedJobInfo();
        expectedJobInfo.setExpectedId(1);
        expectedJobInfo.setUserId(1);
        expectedJobInfo.setReleaseTime(new Timestamp(System.currentTimeMillis()));
        expectedJobInfo.setContactInfo("155");
        expectedJobInfo.setWorkContent("work content change");
        expectedJobInfo.setWorkLocation("hebei");
        expectedJobInfo.setWorkPayment("1500");
        expectedJobInfo.setWorkPeriod("1-8");
        expectedJobInfo.setWorkTime("15h");
        expectedJobInfo.setWorkType("computer");
        System.err.println(expectedJobInfoService.updateExpectedJobInfo(expectedJobInfo));

//        System.err.println(expectedJobInfoService.deleteExpectedJobInfo(3));
    }

}
