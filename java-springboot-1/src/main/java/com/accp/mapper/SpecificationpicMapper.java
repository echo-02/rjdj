package com.accp.mapper;

import com.accp.domain.Specificationpic;
import com.accp.domain.SpecificationpicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationpicMapper {
    int countByExample(SpecificationpicExample example);

    int deleteByExample(SpecificationpicExample example);

    int deleteByPrimaryKey(Integer scpicid);

    int insert(Specificationpic record);

    int insertSelective(Specificationpic record);

    List<Specificationpic> selectByExample(SpecificationpicExample example);

    Specificationpic selectByPrimaryKey(Integer scpicid);

    int updateByExampleSelective(@Param("record") Specificationpic record, @Param("example") SpecificationpicExample example);

    int updateByExample(@Param("record") Specificationpic record, @Param("example") SpecificationpicExample example);

    int updateByPrimaryKeySelective(Specificationpic record);

    int updateByPrimaryKey(Specificationpic record);
}