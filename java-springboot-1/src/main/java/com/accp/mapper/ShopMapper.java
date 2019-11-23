package com.accp.mapper;

import com.accp.domain.Position;
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
    
    @Select("SELECT s.*,(SELECT COUNT(*) FROM `employee` e WHERE s.`shopid`=e.`shopid`) AS COUNT,\n" + 
    		"(SELECT `username` FROM `user` u WHERE u.`userid`=s.`userid`) AS username FROM `shop` s \n" + 
    		"WHERE s.`userid`=#{userid}")
    List<Shop> queryShop(Integer userid);
    
    @Select("SELECT * FROM `shop` WHERE `shopname`=#{shopname}")
    Shop queryShopName(String shopname);
    
    @Select("SELECT * FROM `shop`")
    List<Shop> queryshop();
    
    @Select("SELECT * FROM `position` WHERE `positionid`!=1")
    List<Position> queryPosition();
}