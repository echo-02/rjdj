package com.accp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Balance;
import com.accp.service.BalanceService;
//积分抵扣页面业务
@Controller
@RequestMapping(value="Balance")
public class BalanceCotroller {
	
	@Autowired
	private BalanceService service;
	
	@RequestMapping(value="/selectBalance")
	@ResponseBody
	public Balance selectBalance() {
		return  service.selectBalance();
		
	}
	
	@RequestMapping(value="/updateBalance/{balance}")
	@ResponseBody
	public Map<String,String> updateBlance(@PathVariable int balance) {
		service.updateBlance(balance);
		Map<String, String> map = new HashMap<>();
		map.put("mes", "success");
		return map;
		
	} 
}
