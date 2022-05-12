package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.ExpectedJobInfo;
import com.hebeu.miniprogram.entity.RecruitInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecruitInfoMapper {

    String basicSelectSql = "select ri.recruit_id,\n" +
            "       ri.user_id,\n" +
            "       ri.enterprise_id,\n" +
            "       ri.recruit_type,\n" +
            "       ri.recruit_position,\n" +
            "       ri.work_type,\n" +
            "       ri.work_time,\n" +
            "       ri.work_location,\n" +
            "       ri.work_payment,\n" +
            "       ri.work_content,\n" +
            "       ri.work_period,\n" +
            "       ri.contact_info,\n" +
            "       ri.release_time,\n" +
            "       ei.enterprise_id,\n" +
            "       ei.enterprise_name,\n" +
            "       ei.enterprise_info,\n" +
            "       ei.contact_info\n" +
            "from recruit_info ri\n" +
            "         left join enterprise_info ei on ri.enterprise_id = ei.enterprise_id\n";

    @Options(useGeneratedKeys = true, keyProperty = "recruitId")
    @Insert("insert into recruit_info" +
            "(recruit_id,user_id, enterprise_id, recruit_type, " +
            "recruit_position, work_type, work_time," +
            "work_location, work_payment, work_content, " +
            "work_period, contact_info, release_time) " +
            "values " +
            "(#{recruitId},#{userId},#{enterpriseId},#{recruitType}," +
            "#{recruitPosition},#{workType},#{workTime}," +
            "#{workLocation},#{workPayment},#{workContent}," +
            "#{workPeriod},#{contactInfo},#{releaseTime})")
    int insertRecruitInfo(RecruitInfo recruitInfo);

    //修改招聘信息不可修改recruit id，user id和enterprise id
    @Update("update recruit_info set" +
            "recruit_type=#{recruitType}," +
            "recruit_position=#{recruitPosition}," +
            "work_type=#{workType}," +
            "work_time=#{workTime}," +
            "work_location=#{workLocation}," +
            "work_payment=#{workPayment}," +
            "work_content=#{workContent}," +
            "work_period=#{workPeriod}," +
            "contact_info=#{contactInfo}," +
            "release_time=#{releaseTime}, where recruit_id=#{recruitId}")
    int updateRecruitInfo(RecruitInfo recruitInfo);

    @Delete("delete ri,ei\n" +
            "from recruit_info ri\n" +
            "left join enterprise_info ei " +
            "on ri.enterprise_id = ei.enterprise_id\n" +
            "where ri.recruit_id=#{recruitId}")
    int deleteRecruitInfo(int recruitId);

    @Select(basicSelectSql)
    @Results(id = "recruitInfoResults", value = {
            @Result(column = "recruit_id", property = "recruitId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "enterprise_id", property = "enterpriseId"),
            @Result(column = "recruit_type", property = "recruitType"),
            @Result(column = "recruit_position", property = "recruitPosition"),
            @Result(column = "work_type", property = "workType"),
            @Result(column = "work_time", property = "workTime"),
            @Result(column = "work_location", property = "workLocation"),
            @Result(column = "work_payment", property = "workPayment"),
            @Result(column = "work_content", property = "workContent"),
            @Result(column = "work_period", property = "workPeriod"),
            @Result(column = "contact_info", property = "contactInfo"),
            @Result(column = "release_time", property = "releaseTime"),
            @Result(column = "enterprise_id", property = "enterpriseInfo.enterpriseId"),
            @Result(column = "enterprise_name", property = "enterpriseInfo.enterpriseName"),
            @Result(column = "enterprise_info", property = "enterpriseInfo.enterpriseInfo"),
            @Result(column = "enterprise_contact_info", property = "enterpriseInfo.contactInfo")
    })
    List<RecruitInfo> searchAllRecruit();

    @Select(basicSelectSql + "where recruit_id=#{recruitId}")
    RecruitInfo searchRecruitByRecruitId(int recruitId);

    @Select(basicSelectSql + "where ei.enterprise_name like #{EnterpriseName}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByEnterpriseName(String enterpriseName);

    @Select(basicSelectSql + "where ri.recruit_type = #{recruitType}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByRecruitType(String recruitType);

    @Select(basicSelectSql + "where ri.recruit_position = #{recruitPosition}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByRecruitPosition(String recruitPosition);

    @Select(basicSelectSql + "where ri.work_location = #{workLocation}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByWorkLocation(String workLocation);

    @Select(basicSelectSql + "where ri.work_payment = #{workPayment}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByWorkPayment(String workPayment);

    @Select(basicSelectSql + "where ri.work_period = #{workPeriod}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByWorkPeriod(String workPeriod);

    @Select(basicSelectSql + "where ri.work_type = #{workType}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByWorkType(String workType);

    // "2015-01-01 13:50:42", "2023-02-06 00:00:00"
    @Select(basicSelectSql + "where UNIX_TIMESTAMP(ri.release_time)  >= UNIX_TIMESTAMP(#{beginTime})  and  UNIX_TIMESTAMP(ri.release_time)  <= UNIX_TIMESTAMP(#{endTime})")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByReleaseTime(String beginTime, String endTime);

    // 根据用户id来找其发表过的所有招聘信息
    @Select(basicSelectSql + "where ri.user_id = #{userId}")
    @ResultMap(value = "recruitInfoResults")
    List<RecruitInfo> searchRecruitByUserId(int userId);


}
