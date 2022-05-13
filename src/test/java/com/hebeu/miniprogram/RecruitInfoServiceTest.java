package com.hebeu.miniprogram;

import com.hebeu.miniprogram.entity.EnterpriseInfo;
import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.service.RecruitInfoService;
import com.hebeu.miniprogram.status.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class RecruitInfoServiceTest {

    @Autowired
    private RecruitInfoService recruitInfoService;

    @Test
    void recruitInfoServiceTest(){
        for (int userid=1;userid<=15;userid++){
            RecruitInfo recruitInfo=new RecruitInfo();
            EnterpriseInfo enterpriseInfo=new EnterpriseInfo();
            enterpriseInfo.setEnterpriseInfo("info");
            enterpriseInfo.setContactInfo("1596666666");
            enterpriseInfo.setEnterpriseName("baitianyucompany");
            recruitInfo.setEnterpriseInfo(enterpriseInfo);
            recruitInfo.setUserId(userid);
            recruitInfo.setRecruitPosition("computer-manager");
            recruitInfo.setWorkType("computer");
            recruitInfo.setWorkTime("10h");
            recruitInfo.setWorkLocation("handan");
            recruitInfo.setWorkPayment("100/h");
            recruitInfo.setWorkContent("content");
            recruitInfo.setWorkPeriod("5-10");
            recruitInfo.setContactInfo("15932366827");
            recruitInfo.setReleaseTime(new Timestamp(System.currentTimeMillis()));
            System.err.println("insertRecruitInfo="+recruitInfoService.insertRecruitInfo(recruitInfo));
        }

        System.err.println("searchRecruitByEnterpriseName="+recruitInfoService.searchRecruitByEnterpriseName("%baitianyu%"));
        System.err.println("searchAllRecruit="+recruitInfoService.searchAllRecruit());
        System.err.println("searchRecruitByRecruitId(1)="+recruitInfoService.searchRecruitByRecruitId(1));
        System.err.println("searchRecruitByRecruitPosition="+recruitInfoService.searchRecruitByRecruitPosition("computer-manager"));
        System.err.println("searchRecruitByRecruitType="+recruitInfoService.searchRecruitByRecruitType(Type.ENTERPRISE));
        System.err.println("searchRecruitByUserId(1)="+recruitInfoService.searchRecruitByUserId(1));
        System.err.println("searchRecruitByReleaseTime="+recruitInfoService.searchRecruitByReleaseTime("2022-05-10 0:0:0","2022-05-13 19:19:10"));
        System.err.println("searchRecruitByWorkLocation="+recruitInfoService.searchRecruitByWorkLocation("handan"));
        System.err.println("searchRecruitByWorkPayment="+recruitInfoService.searchRecruitByWorkPayment("100/h"));
        System.err.println("searchRecruitByWorkType="+recruitInfoService.searchRecruitByWorkType("computer"));
        System.err.println("searchRecruitByWorkPeriod="+recruitInfoService.searchRecruitByWorkPeriod("5-10"));

        RecruitInfo recruitInfo=new RecruitInfo();
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        enterpriseInfo.setEnterpriseInfo("newinfo");
        enterpriseInfo.setContactInfo("159");
        enterpriseInfo.setEnterpriseName("baitianyu1111");
        enterpriseInfo.setEnterpriseId(2);
        recruitInfo.setEnterpriseInfo(enterpriseInfo);
        recruitInfo.setRecruitType(Type.ENTERPRISE);
        recruitInfo.setUserId(6);
        recruitInfo.setRecruitId(6);
        recruitInfo.setRecruitPosition("computer-manager");
        recruitInfo.setWorkType("computer");
        recruitInfo.setWorkTime("10h");
        recruitInfo.setWorkLocation("handan");
        recruitInfo.setWorkPayment("199/h");
        recruitInfo.setWorkContent("content");
        recruitInfo.setWorkPeriod("5-11");
        recruitInfo.setContactInfo("15932366855");
        recruitInfo.setReleaseTime(new Timestamp(System.currentTimeMillis()));
        System.err.println("updateRecruitInfo="+recruitInfoService.updateRecruitInfo(recruitInfo));

//        System.err.println("deleteRecruitInfo="+recruitInfoService.deleteRecruitInfo(4));

    }
}
