package com.accp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Goods;
import com.accp.domain.Goodspic;
import com.accp.domain.GoodspicExample;
import com.accp.mapper.GoodsMapper;
import com.accp.mapper.GoodsinstanceMapper;
import com.accp.mapper.GoodspicMapper;

@Service
@Transactional
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodspicMapper goodspicMapper;
	@Autowired
	private GoodsinstanceMapper goodsinstanceMapper;
	/**
	 * 查询商品列表
	 * @param cfid 类别编号
	 * @param gname 商品名称
	 * @return
	 */
	public List<Goods> getGoods(Integer cfid,String gname) {
		List<Goods> goods=new ArrayList<Goods>();
		goods=goodsMapper.getGoods(cfid, gname);
		for (Goods goods2 : goods) {
			GoodspicExample goodspicExample=new GoodspicExample();
			goodspicExample.createCriteria().andGidEqualTo(goods2.getGid());
			if(goodspicMapper.selectByExample(goodspicExample)!=null) {
				Goodspic goodspic=goodspicMapper.selectByExample(goodspicExample).get(0);
				goods2.setPic(goodspic.getPicname());
			}
		}
		return goods;
	}
	/**
	 * 按编号查询商品
	 * @param gid
	 * @return
	 */
	public Goods getGoodsBygid(Integer gid) {
		Goods goods=goodsMapper.selectByPrimaryKey(gid);
		return goods;
	}
	/**
	 * 删除商品
	 * @param gid
	 * @return
	 */
	public int removeGoods(Integer gid) {
		int i=0;
		i=goodsMapper.removeGoods(gid);
		return i;
	}
	/**
	 * 保存商品
	 * @return
	 */
	public int saveGoods(Goods goods,MultipartFile [] files) {
		int i=0;
		//判断商品是否已存在
		if(goods.getGid()==null) {
			//新增
			
		}else {
			//修改
		}
		return i;
	}
}
