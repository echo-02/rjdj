package com.accp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Jurisdiction;
import com.accp.domain.Jurisdictionset;
import com.accp.domain.Position;

import com.accp.service.PositionService;
import com.accp.service.UserService;

@Controller
@RequestMapping("/position")
public class PositionController {
	@Autowired
	PositionService ps;
	@Autowired
	UserService us;
	@Autowired
	
	
	//查询职位信息
	@RequestMapping("/queryAllPosition")
	@ResponseBody
    public List<Position> queryAllPosition(){
    	return ps.queryAllPosition();
    }
	
	//添加职位
	@RequestMapping("/addPosition")
	@ResponseBody
	public String addPosition(@RequestParam String ppname,@RequestParam(value="checked[]") String [] checked) {
       if(ps.queryPositionName(ppname)!=null) {
    	   return "F";
       }else {
    	  ps.addPosition(ppname, checked);
    	  return "T";
       }
       
	}
	
	//修改职位
	@RequestMapping("/updatePosition")
	@ResponseBody
	public String updatePosition(@RequestParam String positionid, @RequestParam String positionname,@RequestParam(value="checked[]") String [] checked) {
	        System.out.println(positionid+"+"+positionname+"+"+checked);
		    ps.updatePosition(positionid,positionname, checked);  
			return "success";
	}
	


	//根据positionid查询信息
	@RequestMapping("/byPositionId")
	@ResponseBody
	public Position byPositionId(Integer positionid) {
		return ps.byPositionId(positionid);
	}
	
	@RequestMapping("/byJurisdictionset")
	@ResponseBody
	public List<Jurisdictionset> byJurisdictionset(Integer positionid) {
		return ps.byJurisdictionset(positionid);
	}
	
	/*
	 * //删除职位
	 * 
	 * @RequestMapping("/removePosition")
	 * 
	 * @ResponseBody public String removePosition(Integer positionid) {
	 * ps.delPosition(positionid); return "success"; }
	 */

	
	
	@RequestMapping("/toModule")
	public String toModule() {
		return "module";
	}
	
	@RequestMapping("/findModuleAll")
	@ResponseBody
	public List<Jurisdiction> findModuleAll() {
		System.out.println("进来了");
		//获取所有模块
		//return ps.findJurisdictionByParentId(0, 0);
		//根据用户获取模块
		List<Jurisdiction> list=ps.findJurisdictionByPositionId(1);
		System.out.println(list);
		return list;
	}
	
}
