package com.accp.mapper;

import com.accp.domain.Goodsinstance;
import com.accp.domain.GoodsinstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsinstanceMapper {
    int countByExample(GoodsinstanceExample example);

    int deleteByExample(GoodsinstanceExample example);

    int deleteByPrimaryKey(Integer giid);

    int insert(Goodsinstance record);

    int insertSelective(Goodsinstance record);

    List<Goodsinstance> selectByExample(GoodsinstanceExample example);

    Goodsinstance selectByPrimaryKey(Integer giid);

    int updateByExampleSelective(@Param("record") Goodsinstance record, @Param("example") GoodsinstanceExample example);

    int updateByExample(@Param("record") Goodsinstance record, @Param("example") GoodsinstanceExample example);

    int updateByPrimaryKeySelective(Goodsinstance record);

    int updateByPrimaryKey(Goodsinstance record);
}