package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Vip;
import com.accp.service.VipService;
import com.github.pagehelper.PageInfo;

@Controller

public class VipController {

	@Autowired
	private VipService service;
	
	//查询所有Vip
	@RequestMapping(value="/selectAllVip")
	@ResponseBody
	public List<Vip> selectAllVip(){
		return service.selectAllVip();
		
	}
	
	//根据id查询Vip
	
	@RequestMapping(value="/selectVipById/{id}")
	@ResponseBody
	public Vip selectVipById(@PathVariable int id) {
		return service.selectVipById(id);
		
	}
	
	//根据条件查询Vip
	@RequestMapping(value="/selectVipByExample")
	@ResponseBody
	public List<Vip> selectVipByExample(Vip vip){
		return service.selectVipByExample(vip);
		
	}
	
	//分页加条件查询
	@RequestMapping(value="/selectVipByPage")
	@ResponseBody
	public PageInfo<Vip> selectVipByPage(int pageNum,int pageSize, Vip vip){
		PageInfo<Vip> pageinfo = service.selectPage(pageNum, pageSize, vip);
		return pageinfo;
	}
	
	//需要成交记录表的 按会员vipid查询 成交记录次数
	
}
