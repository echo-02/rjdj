package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Record;
import com.accp.service.RecordService;
import com.github.pagehelper.PageInfo;

@Controller
public class RecordController {
	@Autowired
	private RecordService service;
	@RequestMapping(value="/selectRecordBypage")
	@ResponseBody
	public PageInfo<Record> selectRecordBypage(int pageNum,int pageSize,Record r,String time){
		
		return service.selectRecordBypage(pageNum, pageSize, r ,time,0);
		
	}
	
	@RequestMapping(value="/selectRecordBypageByP")
	@ResponseBody
	public PageInfo<Record> selectRecordBypageByP(int pageNum,int pageSize ,Record r ,String time){
		return service.selectRecordBypage(pageNum,pageSize,r,time,1);
		
	}
}
