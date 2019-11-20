package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Shop;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.ShopMapper;
import com.accp.mapper.UserMapper;

@Service
@Transactional
public class ShopService {
	@Autowired
	ShopMapper sm;
	@Autowired
	UserMapper um;
	@Autowired
	EmployeeMapper em;
	
    public List<Shop> queryShop(Integer userid){
    	List<Shop> list=sm.queryShop();
    	for(Shop s:list) {
    		
    		s.setEmployee(em.selectByExample(null));
    	}
    	return list;
    }
    
}
