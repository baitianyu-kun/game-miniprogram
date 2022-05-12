package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into user_info(" +
            "open_id, " +
            "user_type, " +
            "phone_number, " +
            "avatar_url, " +
            "nick_name, " +
            "gender, " +
            "language, " +
            "country, " +
            "province, " +
            "city, " +
            "appid) VALUES (" +
            "#{openId}," +
            "#{userType}," +
            "#{phoneNumber}," +
            "#{avatarUrl}," +
            "#{nickName}," +
            "#{gender}," +
            "#{language}," +
            "#{country}," +
            "#{province}," +
            "#{city}," +
            "#{appid})")
    int insertUser(UserInfo userInfo);

    @Select("select * from user_info where open_id = #{openId}")
    UserInfo findUser(String openId);

    @Update("update user_info set phone_number = #{phoneNumber} where user_id = #{userId}")
    int insertUserPhone(int userId, String phoneNumber);

    @Select("select user_type from user_info where user_id=#{userId}")
    String getUserType(int userId);

    @Delete("delete from user_info where user_id=#{userId}")
    int deleteUser(int userId);

    @Update("update user_info set " +
            "user_type=#{userType}," +
            "phone_number=#{phoneNumber}," +
            "avatar_url=#{avatarUrl}," +
            "nick_name=#{nickName}," +
            "gender=#{gender}," +
            "language=#{language}," +
            "country=#{country}," +
            "province=#{province}," +
            "city=#{city}," +
            "appid=#{appid} where user_id=#{userId}")
    int updateUser(UserInfo userInfo);
}
