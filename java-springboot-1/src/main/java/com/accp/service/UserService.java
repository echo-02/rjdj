package com.accp.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Employee;
import com.accp.domain.Shop;
import com.accp.domain.ShopExample;
import com.accp.domain.User;
import com.accp.domain.UserExample;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.ShopMapper;
import com.accp.mapper.UserMapper;

@Service
@Transactional
public class UserService {
   @Autowired
   UserMapper um;

   public User queryNameAndPwd(String username,String password) {
	   UserExample userExample=new UserExample();
	   userExample.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
	   return (User) um.selectByExample(userExample);
   }
   
   public int updateUser(User user) {
	  return um.updateByPrimaryKeySelective(user);
   }
   
   public User byUserId(Integer userid) {
	   return um.selectByPrimaryKey(userid);
   }
   
   public String uploadAjax(MultipartFile [] files,HttpSession session) {
	    User u=new User();
	    User su=(User) session.getAttribute("user");
	    u.setUserid(su.getUserid());
	    File directory = new File("/D:/images");
		if(!directory.exists()) {
			directory.mkdirs();
		}
		
		try {
			for(MultipartFile l : files) {
				String url = "/D:/images/";
				url = url+"/"+l.getOriginalFilename();
				u.setUserpic(l.getOriginalFilename());
				File f = new File(url);
				l.transferTo(f);
			}
			System.out.println("to成功了");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		um.updateByPrimaryKeySelective(u);
		return "success";
   }
 
  
}
