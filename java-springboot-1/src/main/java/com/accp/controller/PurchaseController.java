package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Purchase;
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
}
