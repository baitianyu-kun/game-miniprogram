package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.RecruitInfo;
import com.hebeu.miniprogram.entity.ResumeInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResumeInfoMapper {

    @Options(useGeneratedKeys = true, keyProperty = "resumeId")
    @Insert("insert into resume_info (" +
            "recruit_id, " +
            "user_id, " +
            "resume_file_url, " +
            "resume_status) " +
            "values (#{recruitId},#{userId},#{resumeFileUrl},#{resumeStatus})")
    int insertResumeInfo(ResumeInfo resumeInfo);

    @Delete("delete from resume_info where resume_id=#{resumeId}")
    int deleteResumeInfo(int resumeId);

    @Select("select * from resume_info")
    List<ResumeInfo> searchAllResumeInfo();

    @Select("select * from resume_info where user_id = #{userId}")
    List<ResumeInfo> searchResumeInfoByUserId(int userId);

    @Select("select * from resume_info where resume_id=#{resumeId}")
    ResumeInfo searchResumeInfoByResumeId(int resumeId);

    //根据某个岗位id查找所有简历
    @Select("select * from resume_info where recruit_id=#{recruitId}")
    List<ResumeInfo> searchResumeInfoByRecruitId(int recruitId);

    //更新简历状态信息
    @Update("update resume_info set resume_status=#{resumeStatus} " +
            "where resume_id=#{resumeId}")
    int updateResumeInfoStatus(String resumeStatus, int resumeId);

    //更新简历信息
    @Update("update resume_info set " +
            "resume_file_url=#{resumeFileUrl}," +
            "resume_status=#{resumeStatus} where resume_id=#{resumeId}")
    int updateResumeInfo(ResumeInfo resumeInfo);

}
