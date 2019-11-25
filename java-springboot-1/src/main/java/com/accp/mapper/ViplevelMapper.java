package com.accp.mapper;

import com.accp.domain.Viplevel;
import com.accp.domain.ViplevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ViplevelMapper {
    int countByExample(ViplevelExample example);

    int deleteByExample(ViplevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Viplevel record);

    int insertSelective(Viplevel record);

    List<Viplevel> selectByExample(ViplevelExample example);

    Viplevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Viplevel record, @Param("example") ViplevelExample example);

    int updateByExample(@Param("record") Viplevel record, @Param("example") ViplevelExample example);

    int updateByPrimaryKeySelective(Viplevel record);

    int updateByPrimaryKey(Viplevel record);

	void updateViplevelStatus(int id);
	@Select("select id from viplevel where levelname = #{name} ")
	Integer selectviplvidByname(String name);
}