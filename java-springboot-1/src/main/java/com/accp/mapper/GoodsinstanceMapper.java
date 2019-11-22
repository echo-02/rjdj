package com.accp.mapper;

import com.accp.domain.Goodsinstance;
import com.accp.domain.GoodsinstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsinstanceMapper {
	/**
	 * 改变商品数量
	 * @param num 要修改多少(添加为整数，减少为负数)
	 * @param giid 要修改的详情编号
	 * @return
	 */
	int changeXQNum(@Param("num") Integer num,@Param("giid") Integer giid);
	
	int addEach(@Param("list") List<Goodsinstance> goodsinstances,@Param("gid") Integer gid);
	
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