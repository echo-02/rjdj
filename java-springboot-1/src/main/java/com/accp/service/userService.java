package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.User;
import com.accp.domain.UserExample;
import com.accp.mapper.UserMapper;

@Service
public class userService {
   @Autowired
   UserMapper um;
   public User queryNameAndPwd(String username,String password) {
	   UserExample userExample=new UserExample();
	   userExample.createCriteria().andPasswordEqualTo(password).andUsernameEqualTo(username);
	   return um.selectByExample(userExample);
   }
   
   public int updateShop(User user) {
	   UserExample userExample=new UserExample();
	   userExample.createCriteria().andUseridEqualTo(user.getUserid());
	   return um.updateByExample(user, userExample);
   }
   
}
