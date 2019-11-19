package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Shop;
import com.accp.service.shopService;

@Controller
@RequestMapping("/shop")
public class shopController {
	@Autowired
	shopService ss;
	//查询所有店铺信息
	@RequestMapping("/queryAllShop")
	@ResponseBody
    public List<Shop> queryAllShop() {
    	return ss.queryAllShop();
    }
}
