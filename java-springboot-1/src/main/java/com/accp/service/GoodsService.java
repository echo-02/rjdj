package com.accp.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Goods;
import com.accp.domain.Goodsinstance;
import com.accp.domain.GoodsinstanceExample;
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
	 * 根据商品编号查询图片
	 * @param gid
	 * @return
	 */
	public List<Goodspic> getPicsByGid(Integer gid) {
		GoodspicExample goodspicExample=new GoodspicExample();
		goodspicExample.createCriteria().andGidEqualTo(gid);
		return goodspicMapper.selectByExample(goodspicExample);
	}
	/**
	 * 根据商品详情编号查询信息
	 * @param list
	 * @return
	 */
	public List<Goods> getGoodsBygiids(List<Integer> list) {
		return goodsMapper.getGoodsBygiids(list);
	}
	/**
	 * 查询商品列表
	 * @param cfid 类别编号
	 * @param gname 商品名称
	 * @return
	 */
	public List<Goods> getGoods(Integer cfid,String gname,List<Integer> gids) {
		List<Goods> goods=new ArrayList<Goods>();
		goods=goodsMapper.getGoods(cfid, gname,gids);
		for (Goods goods2 : goods) {
			GoodspicExample goodspicExample=new GoodspicExample();
			goodspicExample.createCriteria().andGidEqualTo(goods2.getGid());
			if(goodspicMapper.selectByExample(goodspicExample)!=null&&goodspicMapper.selectByExample(goodspicExample).size()>0) {
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
		List<Integer> gids=new ArrayList<Integer>();
		gids.add(gid);
		Goods goods=goodsMapper.getGoods(null, null, gids).get(0);
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
	 * @param goods 商品
	 * @param files 图片
	 * @return
	 */
	public int saveGoods(Goods goods,MultipartFile [] pics) {
		int i=0;
		//判断商品是否已存在
		if(goods.getGid()==null) {
			//新增
			i=goodsMapper.insertSelective(goods);
			saveGoodsXQ(goods, pics);
		}else {
			//修改
			i=goodsMapper.updateByPrimaryKeySelective(goods);
			saveGoodsXQ(goods, pics);
		}
		return i;
	}
	/**
	 * 保存商品详情
	 * @param goods 商品
	 * @param files 图片
	 */
	private void saveGoodsXQ(Goods goods, MultipartFile[] pics) {
		GoodsinstanceExample goodsinstanceExample=new GoodsinstanceExample();
		goodsinstanceExample.createCriteria().andGidEqualTo(goods.getGid());
		goodsinstanceMapper.deleteByExample(goodsinstanceExample);
		List<Goodsinstance> goodsinstances=goods.getGoodsinstances();
		if(goodsinstances!=null&&goodsinstances.size()>0) {
			goodsinstanceMapper.addEach(goodsinstances, goods.getGid());
		}
		GoodspicExample goodspicExample=new GoodspicExample();
		goodspicExample.createCriteria().andGidEqualTo(goods.getGid());
		goodspicMapper.deleteByExample(goodspicExample);
		//图片上传
		String path="/D:/";
		File directory = new File(path);
		if(!directory.exists()) {
			directory.mkdirs();
		}
		if(pics!=null&&pics.length>0) {
			for(MultipartFile l : pics) {
				String fileName="images/"+UUID.randomUUID().toString();
				fileName+=l.getOriginalFilename().substring(l.getOriginalFilename().lastIndexOf("."));
				String url = path+"\\"+fileName;
				File f = new File(url);
				try {
					l.transferTo(f);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Goodspic goodspic=new Goodspic();
				goodspic.setGid(goods.getGid());
				goodspic.setPicname(fileName);
				goodspicMapper.insertSelective(goodspic);
			}
		}
	}
}
