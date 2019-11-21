package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Specificationdetails;
import com.accp.domain.SpecificationdetailsExample;
import com.accp.mapper.SpecificationdetailsMapper;

@Service
@Transactional
public class SpecificationService {
	@Autowired
	private SpecificationdetailsMapper specificationdetailsMapper;
	/**
	 * 按父类规格查询
	 * @param sfid
	 * @return
	 */
	public List<Specificationdetails> getSpeDetailsBySfid(Integer sfid) {
		SpecificationdetailsExample specificationdetailsExample=new SpecificationdetailsExample();
		specificationdetailsExample.createCriteria().andSfidEqualTo(sfid);
		return specificationdetailsMapper.selectByExample(specificationdetailsExample);
	}
}
