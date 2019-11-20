package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Topup;
import com.accp.domain.TopupExample;
import com.accp.mapper.TopupMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TopupService {

	@Autowired
	private TopupMapper mapper;
	
	public List<Topup> selectAllTopup(Topup t){
		return mapper.selectAllTopup(t);
		
	}
	
	public PageInfo<Topup> selectTopupBypage(int pageNum,int pageSize,Topup t){
		PageHelper.startPage(pageNum, pageSize);
		List<Topup> list = this.selectAllTopup(t);
		PageInfo<Topup> pageinfo = new PageInfo<>(list);
		return pageinfo;
		
	}
	
}
