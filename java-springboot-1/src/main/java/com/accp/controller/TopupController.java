package com.accp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Topup;
import com.accp.service.TopupService;
import com.github.pagehelper.PageInfo;

@Controller
public class TopupController {
	
	@Autowired
	private TopupService service;
	@RequestMapping(value="/selectAllTopup")
	@ResponseBody
	public List<Topup> selectAllTopup(Topup t){
		return service.selectAllTopup(t);
		
	}
	
	@RequestMapping(value="/selectTopupBypage")
	@ResponseBody
	public PageInfo<Topup> selectTopupBypage(Integer pageNum,Integer pageSize ,Topup t,String time) throws ParseException{
		if(time!=""&&time!=null) {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			t.setTopdate(dateFormat.parse(time.substring(0,10)));
			t.setTopdate2(dateFormat.parse(time.substring(22, 32)));
		}else {
			t.setTopdate(null);
			t.setTopdate2(null);
		}
		
		if(t.getName()=="") {
			t.setName(null);
		}
		
		PageInfo<Topup> pageinfo = service.selectTopupBypage(pageNum, pageSize, t);
		return pageinfo;
		
	}
	
	/*
	 * public Map<String,String> insertTopup(){ return null;
	 * 
	 * }
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
