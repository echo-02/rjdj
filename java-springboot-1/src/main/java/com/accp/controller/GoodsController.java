package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Goods;
import com.accp.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	/**
	 * 查询商品列表
	 * @param cfid 类别编号
	 * @param gname 商品名称
	 * @return
	 */
	@RequestMapping("/getGoods")
	@ResponseBody
	public List<Goods> getGoods(Integer cfid,String gname) {
		return goodsService.getGoods(cfid, gname);
	}
	/**
	 * 按编号查询商品
	 * @param gid
	 * @return
	 */
	@RequestMapping("/getGoodsBygid")
	@ResponseBody
	public Goods getGoodsBygid(Integer gid) {
		return goodsService.getGoodsBygid(gid);
	}
	/**
	 * 删除商品
	 * @param gid
	 * @return
	 */
	@RequestMapping("/removeGoods")
	@ResponseBody
	public int removeGoods(Integer gid) {
		return goodsService.removeGoods(gid);
	}
}
