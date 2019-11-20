package com.accp.mapper;

import com.accp.domain.Shop;
import com.accp.domain.ShopExample;
import com.accp.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShopMapper {
    int countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(Integer shopid);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(Integer shopid);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
    
    @Select("SELECT e.`emid`,u.`username`,s.`shopname`,e.`emname`,s.`contacts`,s.`cellphone`,s.`phone`,s.`address` \n" + 
    		"FROM `shop` s,`employee` e,`user` u\n" + 
    		"WHERE s.`shopid`=e.`shopid` \n" + 
    		"AND u.`userid`=s.`userid`")
    List<Shop> queryShop();
}