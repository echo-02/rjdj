package com.accp.mapper;

import com.accp.domain.Topup;
import com.accp.domain.TopupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopupMapper {
    int countByExample(TopupExample example);

    int deleteByExample(TopupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Topup record);

    int insertSelective(Topup record);

    List<Topup> selectByExample(TopupExample example);

    Topup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Topup record, @Param("example") TopupExample example);

    int updateByExample(@Param("record") Topup record, @Param("example") TopupExample example);

    int updateByPrimaryKeySelective(Topup record);

    int updateByPrimaryKey(Topup record);
    
    List<Topup> selectAllTopup(Topup t);
    

}