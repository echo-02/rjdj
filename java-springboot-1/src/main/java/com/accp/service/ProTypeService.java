package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Classification;
import com.accp.domain.ClassificationExample;
import com.accp.mapper.ClassificationMapper;

@Service
@Transactional
public class ProTypeService {
	@Autowired
	private ClassificationMapper classificationMapper;
	/**
	 * 查询商品类别
	 * @return
	 */
	public List<Classification> getProTypes() {
		ClassificationExample classificationExample=new ClassificationExample();
		classificationExample.createCriteria().andStatusEqualTo(0);
		return classificationMapper.selectByExample(classificationExample);
	}
	/**
	 * 根据编号查询类别
	 * @param id
	 * @return
	 */
	public Classification getProTypeById(Integer id) {
		return classificationMapper.selectByPrimaryKey(id);
	}
	/**
	 * 保存商品类别
	 * @param classification
	 * @return
	 */
	public int saveProType(Classification classification) {
		int i=0;
		i=classificationMapper.insertSelective(classification);
		return i;
	}
	/**
	 * 修改商品类别
	 * @param classification
	 * @return
	 */
	public int updateProType(Classification classification) {
		int i=0;
		i=classificationMapper.updateByPrimaryKeySelective(classification);
		return i;
	}
	/**
	 * 软删除商品类别
	 * @param id
	 * @return
	 */
	public int removeProType(Integer id) {
		int i=0;
		i=classificationMapper.removeProType(id);
		return i;
	}
}
