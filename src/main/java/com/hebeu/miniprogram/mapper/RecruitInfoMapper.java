package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import com.hebeu.miniprogram.entity.RecruitInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface RecruitInfoMapper {

    @Options(useGeneratedKeys = true,keyProperty = "recruit_id")
    @Insert("insert into recruit_info values (#{recruitId},#{userId},#{enterpriseId},#{recruitType},#{recruitPosition},#{workType},#{workTime},#{workLocation},#{workPayment},#{workContent},#{workPeriod},#{contactInfo},#{releaseTime})")
    int insertRecruitInfo(RecruitInfo recruitInfo);


}
