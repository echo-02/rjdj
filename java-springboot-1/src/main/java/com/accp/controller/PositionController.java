package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Position;
import com.accp.domain.User;
import com.accp.service.PositionService;
import com.accp.service.UserService;

@Controller
@RequestMapping("/position")
public class PositionController {
	@Autowired
	PositionService ps;
	@Autowired
	UserService us;
	
	//查询职位信息
	@RequestMapping("/queryAllPosition")
	@ResponseBody
    public List<Position> queryAllPosition(){
    	return ps.queryAllPosition();
    }
	
	@RequestMapping("/addPosition")
	@ResponseBody
	public String addPosition(Position p) {
		 ps.addPosition(p);
		 return "success";
	}
}
