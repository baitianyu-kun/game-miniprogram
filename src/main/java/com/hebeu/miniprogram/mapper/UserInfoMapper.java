package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @Insert("insert into user_info values (#{userId},#{openId},#{userType},#{phoneNumber},#{avatarUrl},#{nickName},#{gender},#{language},#{country},#{province},#{city},#{appid})")
    int insertUser(UserInfo userInfo);

    @Select("select * from user_info where open_id = #{openId}")
    UserInfo findUser(String openId);

    @Update("update user_info set phone_number = #{phoneNumber} where user_id = #{userId}")
    int insertUserPhone(int userId, String phoneNumber);

    @Select("select user_type from user_info where user_id=#{userId}")
    String getUserType(int userId);
}
