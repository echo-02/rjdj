package com.accp.mapper;

import com.accp.domain.Shop;
import com.accp.domain.ShopExample;
import com.accp.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    
    @Select("select s.*,(select count(*) from `employee` e where s.`shopid`=e.`shopid`) as count,\n" + 
    		"(select `username` from `user` u where u.`userid`=s.`userid`) as username from `shop` s\n" + 
    		"where s.`userid`=#{userid}")
    List<Shop> queryShop(Integer userid);
    
    @Select("SELECT * FROM `shop` WHERE `shopname`=#{shopname}")
    Shop queryShopName(String shopname);
}