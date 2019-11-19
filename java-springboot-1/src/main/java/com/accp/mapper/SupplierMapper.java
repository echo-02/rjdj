package com.accp.mapper;

import com.accp.domain.Supplier;
import com.accp.domain.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
	int removeSupplier(Integer id);
	
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}