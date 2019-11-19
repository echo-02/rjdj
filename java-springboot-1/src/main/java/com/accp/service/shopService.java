package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.Shop;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.ShopMapper;
import com.accp.mapper.UserMapper;

@Service
public class shopService {
   @Autowired
   ShopMapper sm;
   @Autowired
   UserMapper um;
   @Autowired
   EmployeeMapper em;
   
   public List<Shop> queryAllShop(){
	   List<Shop> list=sm.selectByExample(null);
	   for(Shop p:list) {
		   p.setUser(um.queryAll());
		   p.setEmployee(em.selectByExample(null));
	   }
	   return list;
   }
}
