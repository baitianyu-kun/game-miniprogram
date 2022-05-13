package com.hebeu.miniprogram;

import com.hebeu.miniprogram.entity.ResumeInfo;
import com.hebeu.miniprogram.service.ResumeInfoService;
import com.hebeu.miniprogram.status.ServiceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResumeInfoServiceTest {

    @Autowired
    private ResumeInfoService resumeInfoService;

    @Test
    void resumeInfoServiceTest(){
        for (int userid_recruitid = 1; userid_recruitid <= 15; userid_recruitid++) {
            ResumeInfo resumeInfo = new ResumeInfo();
            resumeInfo.setResumeStatus(ServiceStatus.RESUME_ACCEPTED);
            resumeInfo.setResumeFileUrl("file url");
            resumeInfo.setRecruitId(userid_recruitid);
            resumeInfo.setUserId(userid_recruitid);
            System.err.println(resumeInfoService.insertResumeInfo(resumeInfo));
        }

        System.err.println("searchAllResumeInfo="+resumeInfoService.searchAllResumeInfo());
        System.err.println("searchResumeInfoByResumeId(1)="+resumeInfoService.searchResumeInfoByResumeId(1));
        System.err.println("searchResumeInfoByRecruitId(2)="+resumeInfoService.searchResumeInfoByRecruitId(2));
        System.err.println("searchResumeInfoByUserId(2)="+resumeInfoService.searchResumeInfoByUserId(2));
        System.err.println("updateResumeInfoStatus="+resumeInfoService.updateResumeInfoStatus(ServiceStatus.RESUME_POSTED,15));

        ResumeInfo resumeInfo=new ResumeInfo();
        resumeInfo.setResumeStatus(ServiceStatus.RESUME_REJECTED);
        resumeInfo.setResumeFileUrl("file url rejected");
        resumeInfo.setRecruitId(100);
        resumeInfo.setUserId(100);
        resumeInfo.setResumeId(14);
        System.err.println("updateResumeInfo="+resumeInfoService.updateResumeInfo(resumeInfo));

//        System.err.println("deleteResumeInfo="+resumeInfoService.deleteResumeInfo(13));
    }

}
