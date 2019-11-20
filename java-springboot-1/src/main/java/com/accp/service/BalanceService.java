package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Balance;
import com.accp.domain.BalanceExample;
import com.accp.mapper.BalanceMapper;

@Service
@Transactional
public class BalanceService {
	@Autowired
	private BalanceMapper mapper;
	
	public Balance selectBalance() {
		return  mapper.selectByExample(null).get(0);
		
	}
	
	public void updateBlance(int balance) {
		Balance b = new Balance();
		b.setBalances(balance);
		BalanceExample examle = new BalanceExample();
		examle.createCriteria().andBalancesEqualTo(this.selectBalance().getBalances());
		mapper.updateByExample(b, examle);
		
	} 
}
