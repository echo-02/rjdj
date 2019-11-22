package com.accp.mapper;

import com.accp.domain.Goods;
import com.accp.domain.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
	/**
	 * 更新商品库存
	 * @param gid 商品编号
	 * @return
	 */
	int updateCount(Integer gid);
	/**
	 * 获取详情数量被改变的商品编号
	 * @param list 改变数量的商品详情编号集合
	 * @return
	 */
	List<Integer> getChangedIds(List<Integer> list);
	
	List<Goods> getGoods(@Param("cfid") Integer cfid,@Param("gname") String gname);
	
	List<Goods> getGoodsBygiids(List<Integer> list);
	
	int removeGoods(Integer gid);
	
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}