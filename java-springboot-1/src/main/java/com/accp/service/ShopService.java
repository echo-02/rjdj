package com.accp.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.accp.domain.Shop;
import com.accp.domain.User;
import com.accp.mapper.ShopMapper;
import com.accp.mapper.UserMapper;

@Service
@Transactional
public class ShopService {
	@Autowired
	ShopMapper sm;
	@Autowired
	UserMapper um;
	
    public List<Shop> queryShop(Integer userid){
    	List<Shop> list=sm.queryShop(userid);
    	return list;
    }
    
    public String addShop(Shop shop,HttpSession session) {
    	User user=new User();
    	User us=(User)session.getAttribute("user");
    	user=um.selectByPrimaryKey(us.getUserid());
    	shop.setUserid(user.getUserid());
    	sm.insertSelective(shop);
    	return "success";
    }
    
    public Shop byShopId(Integer shopid) {
    	return sm.selectByPrimaryKey(shopid);
    }
    
    public int removeShop(Integer shopid) {
    	return sm.deleteByPrimaryKey(shopid);
    }
    
    public int updateShop(Shop shop) {
    	return sm.updateByPrimaryKeySelective(shop);
    }
    
    public Shop queryShopName(String shopname) {
    	return sm.queryShopName(shopname);
    }
    
}
