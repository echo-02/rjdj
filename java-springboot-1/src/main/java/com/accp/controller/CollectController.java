package com.accp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Goods;
import com.accp.domain.Goodsinstance;
import com.accp.domain.Vip;
import com.accp.service.CollectService;

@Controller
@RequestMapping(value="Collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value="/checkout")
	@ResponseBody
	public Map<String,String> checkout(String giid,String vipid,String count,String price,String payway){
		

		return collectService.checkout( giid, vipid, count, price,payway);
		
	}
	
}
