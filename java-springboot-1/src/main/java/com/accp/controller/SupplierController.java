package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Supplier;
import com.accp.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	/**
	 * 根据参数查询供应商
	 * @param province 省
	 * @param city 市
	 * @param sname 供应商名称
	 * @return
	 */
	@RequestMapping("/getSuppliersByParam")
	@ResponseBody
	public List<Supplier> getSuppliersByParam(String province,String city,String sname) {
		return supplierService.getSuppliersByParam(province, city, sname);
	}
	/**
	 * 根据编号查询供应商
	 * @param id
	 * @return
	 */
	@RequestMapping("/getSupplierByid")
	@ResponseBody
	public Supplier getSupplierByid(Integer id) {
		return supplierService.getSupplierByid(id);
	}
	/**
	 * 删除供应商
	 * @param id
	 * @return
	 */
	@RequestMapping("/removeSupplier")
	@ResponseBody
	public int removeSupplier(Integer id) {
		return supplierService.removeSupplier(id);
	}
	/**
	 * 保存供应商信息
	 * @param supplier 有编号则修改，没有则新增
	 * @return
	 */
	@RequestMapping("/saveSupplier")
	@ResponseBody
	public int saveSupplier(Supplier supplier) {
		return supplierService.saveSupplier(supplier);
	}
}
