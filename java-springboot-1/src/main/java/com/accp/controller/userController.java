package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.accp.domain.User;
import com.accp.service.userService;

@Controller
public class userController {
   @Autowired
   userService us;
   
   @RequestMapping("/queryByNameAndPwd")
   @ResponseBody
   public String queryNameAndPwd(String username,String password,Model model) {
	  User user=us.queryNameAndPwd(username, password);
	  if(user==null) {
		  return "F";
	  }else {
		  HttpSession session=getSession();
		  session.setAttribute("user", user);
		  System.out.println(user);
		  return "T";
	  }
   }
   
   public static HttpSession getSession() { 
	    HttpSession session = null; 
	    try { 
	        session = getRequest().getSession(); 
	    } catch (Exception e) {} 
	        return session; 
   } 


   public static HttpServletRequest getRequest() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getRequest(); 
   }
   
   
   @RequestMapping("/updateShop")
   @ResponseBody
   public String updateShop(User user) {
	   System.out.println(user.getUserid());
	   us.updateShop(user);
	   return "success";
   }
	  
   }
    
