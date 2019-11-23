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
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.User;
import com.accp.service.UserService;

@Controller
public class UserController {
   @Autowired
   UserService us;
   
   //验证登录
   @RequestMapping("/queryByNameAndPwd")
   @ResponseBody
   public String queryNameAndPwd(String username,String password,Model model) {
	  User user=us.queryNameAndPwd(username, password);
	  if(user==null) {
		  return "F";
	  }else {
		  HttpSession session=getSession();
		  session.setAttribute("user", user);
		  session.setMaxInactiveInterval(-1);
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
   
   //修改用户信息
   @RequestMapping("/updateUser")
   @ResponseBody
   public String updateUser(User user) {
	   System.out.println(user.getTrade());
	   us.updateUser(user);
	   return "success";
   }
   
   
   //修改用户信息后根据userid再查一遍
   @RequestMapping("/byUserId")
   @ResponseBody
   public User byUserId(Integer userid) {
	   return us.byUserId(userid);
   }
   
   //文件上传用来修改头像
   @RequestMapping("/uploadAjax")
   @ResponseBody
   public String uploadAjax(MultipartFile [] files,HttpSession session) {
 		return us.uploadAjax(files, session);
   }  
   
   
   }