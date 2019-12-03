package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Viplevel;
import com.accp.service.ViplevelService;

@Controller
@RequestMapping(value="Viplevel")
public class ViplevelController {

	@Autowired
	private ViplevelService service;
	
	//查询所有等级信息
	@RequestMapping(value="/selectAllViplevel")
	@ResponseBody
	public List<Viplevel> selectAllViplevel(){
		return service.selectAllViplevel();
		
	}
	
	//根据等级id查询等级信息
	@RequestMapping(value="/selectViplevelById/{id}")
	@ResponseBody
	public Viplevel selectViplevelById(@PathVariable int id) {
		return service.selectViplevelById(id);
		
	}
	
	//查询”全部等级“ 之外的 等级
	@RequestMapping(value="/selectViplevelexclude_1")
	@ResponseBody
	public List<Viplevel> selectViplevelexclude_1(){
		return service.selectViplevelexclude_1();
		
	}
	
	//删除等级
	@RequestMapping(value="/deleteViplevelById/{id}")
	@ResponseBody
	public void deleteViplevelById(@PathVariable int id) {
		service.deleteViplevelById(id);
	}
		
	//添加等级
	@RequestMapping(value="/insertViplevel")
	@ResponseBody
	public String deleteViplevelById(Viplevel lv) {
		service.insertViplevel(lv);
		return "success";
	}
	//修改等级
	@RequestMapping(value="/updateViplevel")
	@ResponseBody
	public String updateViplevelById(Viplevel lv) {
		service.updateViplevel(lv);
		return "success";
	}
	

}
