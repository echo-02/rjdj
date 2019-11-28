package com.accp.mapper;
import com.accp.domain.Jurisdictionset;
import com.accp.domain.JurisdictionsetExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface JurisdictionsetMapper {

    int countByExample(JurisdictionsetExample example);

    int deleteByExample(JurisdictionsetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jurisdictionset record);

    int insertSelective(Jurisdictionset record);

    List<Jurisdictionset> selectByExample(JurisdictionsetExample example);

    Jurisdictionset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jurisdictionset record, @Param("example") JurisdictionsetExample example);

    int updateByExample(@Param("record") Jurisdictionset record, @Param("example") JurisdictionsetExample example);

    int updateByPrimaryKeySelective(Jurisdictionset record);

    int updateByPrimaryKey(Jurisdictionset record);
    @Select("SELECT * FROM `jurisdictionset` WHERE `positionid`=#{position}")
    List<Jurisdictionset> by(Integer position);
    
    @Delete("DELETE FROM `jurisdictionset` WHERE `positionid`=#{positionid}")
    int deletePositionid(Integer positionid);
}