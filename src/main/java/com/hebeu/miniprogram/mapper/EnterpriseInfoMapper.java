package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.EnterpriseInfo;
import com.hebeu.miniprogram.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface EnterpriseInfoMapper {

    @Options(useGeneratedKeys = true,keyProperty = "enterprise_id")
    @Insert("insert into enterprise_info values (#{enterpriseId},#{enterpriseName},#{enterpriseInfo},#{contactInfo})")
    int insertEnterpriseInfo(EnterpriseInfo enterpriseInfo);
}
