package com.accp.mapper;

import com.accp.domain.Carinstance;
import com.accp.domain.CarinstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarinstanceMapper {
    int countByExample(CarinstanceExample example);

    int deleteByExample(CarinstanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Carinstance record);

    int insertSelective(Carinstance record);

    List<Carinstance> selectByExample(CarinstanceExample example);

    Carinstance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Carinstance record, @Param("example") CarinstanceExample example);

    int updateByExample(@Param("record") Carinstance record, @Param("example") CarinstanceExample example);

    int updateByPrimaryKeySelective(Carinstance record);

    int updateByPrimaryKey(Carinstance record);
}