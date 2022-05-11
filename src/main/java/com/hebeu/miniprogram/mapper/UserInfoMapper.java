package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Options(useGeneratedKeys = true,keyProperty = "user_id")
    @Insert("insert into user_info values (#{userId},#{openId},#{userType},#{phoneNumber},#{avatarUrl},#{nickName},#{gender},#{language},#{country},#{province},#{city},#{appid})")
    int insertUser(UserInfo userInfo);

    @Select("select * from user_info where open_id = #{openId}")
    UserInfo findUser(String openId);

}
