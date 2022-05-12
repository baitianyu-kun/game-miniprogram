package com.hebeu.miniprogram.mapper;

import com.hebeu.miniprogram.entity.EnterpriseInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseInfoMapper {

    @Options(useGeneratedKeys = true, keyProperty = "enterpriseId")
    @Insert("insert into enterprise_info(" +
            "enterprise_name, " +
            "enterprise_info, " +
            "contact_info) " +
            "values (#{enterpriseName},#{enterpriseInfo},#{contactInfo})")
    int insertEnterpriseInfo(EnterpriseInfo enterpriseInfo);

    @Delete("delete from enterprise_info where enterprise_id = #{enterpriseId}")
    int deleteEnterpriseInfo(int enterpriseId);

    @Select("select * from enterprise_info")
    List<EnterpriseInfo> searchAllEnterpriseInfo();

    @Select("select * from enterprise_info where enterprise_name like #{enterpriseName}")
    List<EnterpriseInfo> searchEnterpriseInfoByName(String enterpriseName);

    @Select("select * from enterprise_info where enterprise_id=#{enterpriseId}")
    EnterpriseInfo searchEnterpriseInfoById(int enterpriseId);

    @Update("update enterprise_info set " +
            "enterprise_name=#{enterpriseName}," +
            "enterprise_info=#{enterpriseInfo}," +
            "contact_info=#{contactInfo} where enterprise_id=#{enterpriseId}")
    int updateEnterpriseInfo(EnterpriseInfo enterpriseInfo);

}
