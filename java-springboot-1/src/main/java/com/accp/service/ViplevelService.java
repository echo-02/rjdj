package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Viplevel;
import com.accp.domain.ViplevelExample;
import com.accp.mapper.ViplevelMapper;

@Service
@Transactional
public class ViplevelService {
	@Autowired
	private ViplevelMapper mapper;
	
	//查询所有等级信息
	public List<Viplevel> selectAllViplevel(){
		return mapper.selectByExample(null);
		
	}
	//根据id查询等级信息
	public Viplevel selectViplevelById(int id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}
	
	//查询”全部等级“ 之外的  所有等级信息
	public List<Viplevel> selectViplevelexclude_1() {
		ViplevelExample exam = new ViplevelExample();
		exam.createCriteria().andIdGreaterThan(1).andStatusNotEqualTo(0);
		return mapper.selectByExample(exam);
		
	}
	public void deleteViplevelById(int id) {
		// TODO Auto-generated method stub
		/*
		 * ViplevelExample exam = new ViplevelExample();
		 * exam.createCriteria().andIdEqualTo(id); Viplevel lv = new Viplevel();
		 * lv.setStatus(1); mapper.updateByExample(lv, exam);
		 */
		mapper.updateViplevelStatus(id);
	}
	public void insertViplevel(Viplevel lv) {
		// TODO Auto-generated method stub
		lv.setStatus(1);
		mapper.insert(lv);
	}
	public void updateViplevel(Viplevel lv) {
		// TODO Auto-generated method stub
		lv.setStatus(1);
		mapper.updateByPrimaryKey(lv);
	}
}
