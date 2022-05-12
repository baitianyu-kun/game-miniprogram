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
            "contact_info)\n" +
            "values #{enterpriseName},#{enterpriseInfo},#{contactInfo}")
    int insertEnterpriseInfo(EnterpriseInfo enterpriseInfo);

    @Delete("delete from enterprise_info where enterprise_id = #{enterpriseId}")
    int deleteEnterpriseInfo(int enterpriseId);

    @Select("select * from enterprise_info")
    List<EnterpriseInfo> searchAllEnterpriseInfo();

    @Select("select * from enterprise_info where enterprise_name like #{enterpriseName}")
    List<EnterpriseInfo> searchEnterpriseInfoByName(String enterpriseName);

    @Select("select * from enterprise_info where enterprise_id=#{enterpriseId}")
    EnterpriseInfo searchEnterpriseInfoById(int enterpriseId);

}
