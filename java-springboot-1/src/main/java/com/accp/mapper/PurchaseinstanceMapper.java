package com.accp.mapper;

import com.accp.domain.Purchaseinstance;
import com.accp.domain.PurchaseinstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseinstanceMapper {
	int addEach(@Param("list") List<Purchaseinstance> list,@Param("pid") String pid);
	
    int countByExample(PurchaseinstanceExample example);

    int deleteByExample(PurchaseinstanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Purchaseinstance record);

    int insertSelective(Purchaseinstance record);

    List<Purchaseinstance> selectByExample(PurchaseinstanceExample example);

    Purchaseinstance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Purchaseinstance record, @Param("example") PurchaseinstanceExample example);

    int updateByExample(@Param("record") Purchaseinstance record, @Param("example") PurchaseinstanceExample example);

    int updateByPrimaryKeySelective(Purchaseinstance record);

    int updateByPrimaryKey(Purchaseinstance record);
}