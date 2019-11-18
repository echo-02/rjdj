package com.accp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Supplier;
import com.accp.domain.SupplierExample;
import com.accp.mapper.SupplierMapper;

@Service
@Transactional
public class SupplierService {
	@Autowired
	private SupplierMapper supplierMapper;
	/**
	 * 根据参数查询供应商
	 * @param province 省
	 * @param city 市
	 * @param sname 供应商名称
	 * @return
	 */
	public List<Supplier> getSuppliersByParam(String province,String city,String sname) {
		List<Supplier> suppliers=new ArrayList<Supplier>();
		if(province==null) {
			province="";
		}
		if(city==null) {
			city="";
		}
		if(sname==null) {
			sname="";
		}
		SupplierExample supplierExample=new SupplierExample();
		supplierExample.createCriteria().andSnameLike("%"+sname+"%")
		.andProvinceLike("%"+province+"%").andCityLike("%"+city+"%");
		return suppliers;
	}
}
