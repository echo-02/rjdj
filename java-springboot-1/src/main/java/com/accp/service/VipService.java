package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Vip;
import com.accp.domain.VipExample;
import com.accp.mapper.VipMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class VipService {
	@Autowired
	private VipMapper mapper;
	
	//查询所有vip
	public List<Vip> selectAllVip(){
		return mapper.selectByExample(null);
		
	}
	
	//根据条件查询Vip
	public List<Vip> selectVipByExample(Vip vip){
		VipExample vipe = new VipExample();
		com.accp.domain.VipExample.Criteria criteria = vipe.createCriteria();
		//加条件
		if(vip.getVlid()!=null&&vip.getVlid()!=1) {
			criteria.andVlidEqualTo(vip.getVlid());
		}
		if((vip.getName()!=null)&&(!vip.getName().equals(""))) {
			criteria.andNameLike("%"+vip.getName()+"%");
		}
		//vipe.createCriteria().andVlidEqualTo(vip.getVlid());
		//vipe.createCriteria().andNameLike("%"+vip.getName()+"%");
		//vipe.or().andVlidEqualTo(vip.getVlid());
		return mapper.selectByExample(vipe);
		
	}
	
	//根据id查询单个Vip
	public Vip selectVipById(int id) {
		return mapper.selectByPrimaryKey(id);
		
	}
	
	//Vip条件分页查询（在方法selectVipByExample中改变条件）
	
	public PageInfo<Vip> selectPage(int pageNum,int pageSize,Vip vip){
		PageHelper.startPage(pageNum, pageSize);
		List<Vip> list =this.selectVipByExample(vip);
		PageInfo<Vip> pageinfo = new PageInfo<>(list);
		return pageinfo;
		
	}

	public void insertVip(Vip vip) {
		// TODO Auto-generated method stub
		mapper.insert(vip);
	}

	public void updateVip(Vip vip) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(vip);
	}
}
