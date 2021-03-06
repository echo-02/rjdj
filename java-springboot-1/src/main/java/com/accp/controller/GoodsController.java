package com.accp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Goods;
import com.accp.domain.Goodspic;
import com.accp.domain.Specificationdetails;
import com.accp.service.GoodsService;
import com.accp.service.SpecificationService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private SpecificationService specificationService;
	/**
	 * 根据商品编号查询图片
	 * @param gid
	 * @return
	 */
	@RequestMapping("/getPicsByGid")
	@ResponseBody
	public List<Goodspic> getPicsByGid(Integer gid) {
		return goodsService.getPicsByGid(gid);
	}
	/**
	 * 根据商品详情编号查询信息
	 * @param list
	 * @return
	 */
	@RequestMapping("/getGoodsBygiids")
	@ResponseBody
	public List<Goods> getGoodsBygiids(String giids) {
		List<Integer> list=new ArrayList<Integer>();
		String[] giid =giids.split(",");
		for (String string : giid) {
			Integer id=Integer.parseInt(string);
			list.add(id);
		}
		return goodsService.getGoodsBygiids(list);
	}
	/**
	 * 查询商品列表
	 * @param cfid 类别编号
	 * @param gname 商品名称
	 * @return
	 */
	@RequestMapping("/getGoods")
	@ResponseBody
	public List<Goods> getGoods(Integer cfid,String gname,String gidsstr) {
		List<Integer> gids=new ArrayList<Integer>();
		if(gidsstr!=null) {
			String[] gid=gidsstr.split(",");
			for (String string : gid) {
				gids.add(Integer.parseInt(string));
			}			
		}
		return goodsService.getGoods(cfid, gname,gids);
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
	/**
	 * 按父类规格查询
	 * @param sfid
	 * @return
	 */
	@RequestMapping("/getSpeDetailsBySfid")
	@ResponseBody
	public List<Specificationdetails> getSpeDetailsBySfid(Integer sfid) {
		return specificationService.getSpeDetailsBySfid(sfid);
	}
	/**
	 * 保存商品
	 * @param goods 商品
	 * @param files 图片
	 * @return
	 */
	@RequestMapping("/saveGoods")
	public String saveGoods(Goods goods,MultipartFile [] pics) {
		goodsService.saveGoods(goods, pics);
		return "redirect:/proManagement";
	}
}
