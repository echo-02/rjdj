package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Purchase;
import com.accp.domain.Purchaseinstance;
import com.accp.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	/**
	 * 保存采购信息
	 * @param purchase
	 * @return
	 */
	@RequestMapping("/savePurchase")
	@ResponseBody
	public int savePurchase(@RequestBody Purchase purchase) {
		return purchaseService.savePurchase(purchase);
	}
	/**
	 * 判断采购单号是否存在
	 * @param pid
	 * @return
	 */
	@RequestMapping("/ckPid")
	@ResponseBody
	public boolean ckPid(String pid) {
		return purchaseService.ckPid(pid);
	}
	/**
	 * 查询采购单列表
	 * @param startseachtime
	 * @param endseachtime
	 * @return
	 */
	@RequestMapping("/getPurchase")
	@ResponseBody
	public List<Purchase> getPurchase(String startseachtime,String endseachtime,String sname) {
		return purchaseService.getPurchase(startseachtime, endseachtime, sname);
	}
	/**
	 * 查询采购单详情
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getPurinsByPid")
	@ResponseBody
	public List<Purchaseinstance> getPurinsByPid(String pid) {
		return purchaseService.getPurinsByPid(pid);
	}
	/**
	 * 审核采购单
	 * @param id
	 * @return
	 */
	@RequestMapping("/checkPurchase")
	@ResponseBody
	public int checkPurchase(String id) {
		return purchaseService.checkPurchase(id);
	}
}
