package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Shop;
import com.accp.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	ShopService ss;
	//查询店铺信息
	@RequestMapping("/queryAllShop")
	@ResponseBody
	public List<Shop> queryAllShop(Integer userid){
		return ss.queryShop(userid);
	}
	
	//新增门店
	@RequestMapping("/addShop")
	@ResponseBody
	public String addShop(Shop shop,HttpSession seesion){
		System.out.println(shop.getShopname());
	    if(ss.queryShopName(shop.getShopname())!=null) {
			return "店铺已存在";
		}
		String e=ss.addShop(shop,seesion);
		return e;
	}
	
	
	
	//根据shopid查询信息
    @RequestMapping("/byShopId")
	@ResponseBody
	public Shop byShopId(Integer shopid){
    	return ss.byShopId(shopid);
	}
    
    //删除门店
    @RequestMapping("/removeShop")
	@ResponseBody
	public String removeShop(Integer shopid){
    	ss.removeShop(shopid);
    	return "success";
	}
    
    //修改门店
    @RequestMapping("/updateShop")
	@ResponseBody
	public String updateShop(Shop shop){
    	ss.updateShop(shop);
    	return "success";
	}
    
	
	
}
