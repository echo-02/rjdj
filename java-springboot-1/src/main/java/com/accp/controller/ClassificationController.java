package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Classification;
import com.accp.service.ProTypeService;

@Controller
@RequestMapping("/Classification")
public class ClassificationController {
	@Autowired
	private ProTypeService proTypeService;
	/**
	 * 查询商品类别
	 * @return
	 */
	@RequestMapping("/getProTypes")
	@ResponseBody
	public List<Classification> getProTypes() {
		return proTypeService.getProTypes();
	}
	/**
	 * 根据编号查询类别
	 * @param id
	 * @return
	 */
	@RequestMapping("/getProTypeById")
	@ResponseBody
	public Classification getProTypeById(Integer id) {
		return proTypeService.getProTypeById(id);
	}
	/**
	 * 保存商品类别
	 * @param classification
	 * @return
	 */
	@RequestMapping("/saveProType")
	@ResponseBody
	public int saveProType(Classification classification) {
		return proTypeService.saveProType(classification);
	}
	/**
	 * 修改商品类别
	 * @param classification
	 * @return
	 */
	@RequestMapping("/updateProType")
	@ResponseBody
	public int updateProType(Classification classification) {
		return proTypeService.updateProType(classification);
	}
	/**
	 * 软删除商品类别
	 * @param id
	 * @return
	 */
	@RequestMapping("/removeProType")
	@ResponseBody
	public int removeProType(Integer id) {
		return proTypeService.removeProType(id);
	}
}
