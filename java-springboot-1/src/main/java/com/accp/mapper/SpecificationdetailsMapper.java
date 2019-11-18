package com.accp.mapper;

import com.accp.domain.Specificationdetails;
import com.accp.domain.SpecificationdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationdetailsMapper {
    int countByExample(SpecificationdetailsExample example);

    int deleteByExample(SpecificationdetailsExample example);

    int deleteByPrimaryKey(Integer sfdid);

    int insert(Specificationdetails record);

    int insertSelective(Specificationdetails record);

    List<Specificationdetails> selectByExample(SpecificationdetailsExample example);

    Specificationdetails selectByPrimaryKey(Integer sfdid);

    int updateByExampleSelective(@Param("record") Specificationdetails record, @Param("example") SpecificationdetailsExample example);

    int updateByExample(@Param("record") Specificationdetails record, @Param("example") SpecificationdetailsExample example);

    int updateByPrimaryKeySelective(Specificationdetails record);

    int updateByPrimaryKey(Specificationdetails record);
}