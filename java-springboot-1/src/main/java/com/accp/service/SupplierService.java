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
		.andProvinceLike("%"+province+"%").andCityLike("%"+city+"%")
		.andStatusEqualTo(0);
		suppliers=supplierMapper.selectByExample(supplierExample);
		return suppliers;
	}
	/**
	 * 根据编号查询供应商
	 * @param id
	 * @return
	 */
	public Supplier getSupplierByid(Integer id) {
		return supplierMapper.selectByPrimaryKey(id);
	}
	/**
	 * 删除供应商
	 * @param id
	 * @return
	 */
	public int removeSupplier(Integer id) {
		return supplierMapper.removeSupplier(id);
	}
	/**
	 * 保存供应商信息
	 * @param supplier 有编号则修改，没有则新增
	 * @return
	 */
	public int saveSupplier(Supplier supplier) {
		int i=0;
		if(supplier.getSid()==null||supplier.getSid()==0) {
			i=supplierMapper.insertSelective(supplier);
		}else {
			i=supplierMapper.updateByPrimaryKeySelective(supplier);
		}
		return i;
	}
}
