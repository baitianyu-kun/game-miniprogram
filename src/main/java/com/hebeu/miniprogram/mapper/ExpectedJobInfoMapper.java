package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.EnterpriseInfo;
import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExpectedJobInfoMapper {

    @Options(useGeneratedKeys = true, keyProperty = "expectedId")
    @Insert("insert into expected_job_info values (#{expectedId},#{userId},#{workTime},#{workLocation},#{workPayment},#{workType},#{workContent},#{workPeriod},#{contactInfo},#{releaseTime})")
    int insertExpectedJobInfo(ExpectedJobInfo expectedJobInfo);

    @Delete("delete from expected_job_info where expected_id=#{expectedId}")
    int deleteExpectedJobInfo(int expectedId);

    @Select("select * from expected_job_info")
    List<ExpectedJobInfo> searchAllExpectedJobInfo();

    @Select("select * from expected_job_info where user_id=#{userId}")
    List<ExpectedJobInfo> searchExpectedJobInfoByUserId(int userId);

    @Update("update expected_job_info set " +
            "work_time=#{workTime}," +
            "work_location=#{workLocation}," +
            "work_payment=#{workPayment}," +
            "work_type=#{workType}," +
            "work_content=#{workContent}," +
            "work_period=#{workPeriod}," +
            "contact_info=#{contactInfo}," +
            "release_time=#{releaseTime} where expected_id=#{expectedId}")
    int updateExpectedJobInfo(ExpectedJobInfo expectedJobInfo);

}
