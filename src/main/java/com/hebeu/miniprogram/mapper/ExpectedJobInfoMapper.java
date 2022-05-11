package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.EnterpriseInfo;
import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ExpectedJobInfoMapper {

    @Options(useGeneratedKeys = true,keyProperty = "expected_id")
    @Insert("insert into expected_job_info values (#{expectedId},#{userId},#{workTime},#{workLocation},#{workPayment},#{workType},#{workContent},#{workPeriod},#{contactInfo},#{releaseTime})")
    int insertExpectedJobInfo(ExpectedJobInfo expectedJobInfo);

}
