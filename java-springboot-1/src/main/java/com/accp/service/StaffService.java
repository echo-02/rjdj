package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Employee;
import com.accp.domain.Position;
import com.accp.domain.Shop;
import com.accp.domain.User;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.PositionMapper;
import com.accp.mapper.ShopMapper;
import com.accp.mapper.UserMapper;

@Service
@Transactional
public class StaffService {
	@Autowired
	EmployeeMapper em;
	@Autowired
	ShopMapper sm;
	@Autowired 
	PositionMapper pm;
    public List<Employee> queryAllStaff(){
    	return em.queryAllStaff();
    }
    
    public Employee byEmdid(Integer emid){
    	return em.byEmid(emid);
    }
    
    public List<Shop> queryShop(){
    	return sm.queryshop();
    }
    
    public List<Position> queryPosition(){
    	return sm.queryPosition();
    }
    
    public List<Employee> byShopQuery(Integer shopid){
    	return em.byShopQuery(shopid);
    }
    
    public List<Employee> byPositionQuery(Integer position){
    	return em.byPositionQuery(position);
    }
    
    public int removePosition(String jobnum){
    	return em.removePosition(jobnum);
    }
    
    public int updatePosition(Employee e) {
    	return em.updateByPrimaryKeySelective(e);
    }
    
    public int addPosition(Employee e) {
    	e.setStatus(0);
    	return em.insertSelective(e);
    }
    
    public Employee queryJobnum(String jobnum) {
    	return em.queryJobnum(jobnum);
    }
    
}
