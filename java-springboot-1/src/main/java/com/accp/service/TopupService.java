package com.accp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Topup;
import com.accp.domain.TopupExample;
import com.accp.domain.Vip;
import com.accp.domain.VipExample;
import com.accp.mapper.TopupMapper;
import com.accp.mapper.VipMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TopupService {

	@Autowired
	private TopupMapper mapper;
	
	@Autowired
	private VipMapper vipMapper;
	
	//跟据条件查询充值抵扣页面
	public List<Topup> selectAllTopup(Topup t){
		return mapper.selectAllTopup(t);
		
	}
	//分页
	public PageInfo<Topup> selectTopupBypage(int pageNum,int pageSize,Topup t){
		PageHelper.startPage(pageNum, pageSize);
		List<Topup> list = this.selectAllTopup(t);
		PageInfo<Topup> pageinfo = new PageInfo<>(list);
		return pageinfo;
		
	}
	
	//充值抵扣表（会员表要插入数据）
	
	public Map<String,String> insertTopup(Topup t) {
		Map<String,String> map = new HashMap<>();
		//冲值表插入数据
		t.setTopdate(new Date());
		Vip vip = new Vip();
		VipExample vipExample = new VipExample();
		vipExample.createCriteria().andPhoneEqualTo(t.getPhone());
		List<Vip> list= vipMapper.selectByExample(vipExample);
		if(0!=list.size()) {
			vip=vipMapper.selectByExample(vipExample).get(0);
		}else {
			map.put("mes", "账号不存在");
			return map;
		}
		t.setVipid(vip.getId());
		mapper.insert(t);
		//获取插入数据的viid和充值的金额，赠送的积分
		Integer Tvipid = t.getVipid();//充值账户
		Double Tmoney =t.getMoney();
		Integer Tpresenter = t.getPresenter();
		
		//查询VIP的余额 级 积分 
		Double preBalance = vip.getBalance();//获取之前的余额
		Integer prepresenter = vip.getIntegral();//积分
		
	
		//修改会员表的数据 为此次 充值 修改 合并数据
		vip.setBalance(Tmoney+preBalance);
		vip.setIntegral(Tpresenter+prepresenter);
		
		vipMapper.updateByPrimaryKey(vip);
		map.put("mes","success");
		return map;
	}
}
