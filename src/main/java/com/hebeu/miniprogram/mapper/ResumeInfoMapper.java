package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.entity.ResumeInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ResumeInfoMapper {

    @Options(useGeneratedKeys = true,keyProperty = "resume_id")
    @Insert("insert into resume_info values (#{resumeId},#{recruitId},#{userId},#{resumeFileUrl},#{resumeStatus})")
    int insertResumeInfo(ResumeInfo resumeInfo);

}
