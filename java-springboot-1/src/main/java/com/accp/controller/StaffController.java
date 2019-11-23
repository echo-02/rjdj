package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Employee;
import com.accp.domain.Position;
import com.accp.domain.Shop;
import com.accp.domain.User;
import com.accp.service.StaffService;
import com.accp.service.UserService;

@Controller
@RequestMapping("/Staff")
public class StaffController {
      @Autowired
      StaffService staffService;
      //查询所有员工
      @RequestMapping("/queryAllStaff")
      @ResponseBody
      public List<Employee> queryAllStaff(){
    	  return staffService.queryAllStaff();
      }
      //查询单个员工信息
      @RequestMapping("/byEmid")
      @ResponseBody
      public Employee byEmid(Integer emid){
    	  return staffService.byEmdid(emid);
      }
      //查询所有店铺
      @RequestMapping("/queryshop")
      @ResponseBody
      public List<Shop> queryshop(){
    	  return staffService.queryShop();
      }
      //查询所有职位
      @RequestMapping("/queryPosition")
      @ResponseBody
      public List<Position> queryPosition(){
    	  return staffService.queryPosition();
      }
      //根据店铺查询的结果
      @RequestMapping("/byShopQuery")
      @ResponseBody
      public List<Employee> byShopQuery(Integer shopid){
    	  return staffService.byShopQuery(shopid);
      }
      //根据职位查询的结果
      @RequestMapping("/byPositionQuery")
      @ResponseBody
      public List<Employee> byPositionQuery(Integer positionid){
    	  return staffService.byPositionQuery(positionid);
      }
      //删除员工
      @RequestMapping("/removePosition")
      @ResponseBody
      public String removePosition(String jobnum){
    	   staffService.removePosition(jobnum);
    	   return "success";
      }
      
      //新增员工
      @RequestMapping("/addPosition")
      @ResponseBody
      public String addPosition(Employee e){
    	   if(staffService.queryJobnum(e.getJobnum())!=null){
    		   return "F";
    	   }else {
    		   staffService.addPosition(e);
    		   return "T";
    	   }

      }
      
      //修改员工信息
      @RequestMapping("/updatePosition")
      @ResponseBody
      public String updatePosition(Employee e){
   	    	   staffService.updatePosition(e);
     	       return "000";   
      }

}
