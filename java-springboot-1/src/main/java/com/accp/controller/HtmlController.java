package com.accp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.domain.User;

@Controller
public class HtmlController {
	/**
	 * 前往首页(用户信息修改页面)index
	 * @return
	 */
	@RequestMapping("/index")
	public String gotoindex(HttpSession session) {
		User user=(User) session.getAttribute("user");
		if(user==null) {
			return "forward:/login";
		}
		return "index";
	}
	/**
	 * 前往权限管理页面
	 * @return
	 */
	@RequestMapping("/authorityManagement")
	public String gotoauthorityManagement() {
		return "authorityManagement";
	}
	
	/**
	 * 前往充值抵扣页面
	 * @return
	 */
	@RequestMapping("/chargingOffset")
	public String gotochargingOffset() {
		return "chargingOffset";
	}
	/**
	 * 前往收银页面
	 * @return
	 */
	@RequestMapping("/collect")
	public String gotocollect() {
		return "collect";
	}
	
	/**
	 * 无权限页面
	 * @return
	 */
	@RequestMapping("/none")
	public String none() {
		return "none";
	}
	
	
	/**
	 * 前往积分设置页面
	 * @return
	 */
	@RequestMapping("/integralSetting")
	public String gotointegralSetting() {
		return "integralSetting";
	}
	/**
	 * 前往等级设置页面
	 * @return
	 */
	@RequestMapping("/levelSetting")
	public String gotolevelSetting() {
		return "levelSetting";
	}
	/**
	 * 前往登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String gotologin() {
		return "login";
	}
	/**
	 * 前往职位权限页面
	 * @return
	 */
	@RequestMapping("/positionAuthority")
	public String gotopositionAuthority() {
		return "positionAuthority";
	}
	/**
	 * 前往商品管理页面
	 * @return
	 */
	@RequestMapping("/proManagement")
	public String gotoproManagement() {
		return "proManagement";
	}
	/**
	 * 前往商品类别页面
	 * @return
	 */
	@RequestMapping("/proType")
	public String gotoproType() {
		return "proType";
	}
	/**
	 * 前往商品上传页面
	 * @return
	 */
	@RequestMapping("/proUploading")
	public String gotoproUploading(Integer gid,Model model) {
		model.addAttribute("gid", gid);
		return "proUploading";
	}
	/**
	 * 前往采购单页面
	 * @return
	 */
	@RequestMapping("/purchase")
	public String gotopurchase() {
		return "purchase";
	}
	/**
	 * 前往店铺管理页面
	 * @return
	 */
	@RequestMapping("/shopManagement")
	public String gotoshopManagement() {
		return "shopManagement";
	}
	/**
	 * 前往员工管理页面
	 * @return
	 */
	@RequestMapping("/staffManagement")
	public String gotostaffManagement() {
		return "staffManagement";
	}
	/**
	 * 前往供应商页面
	 * @return
	 */
	@RequestMapping("/supplier")
	public String gotosupplier() {
		return "supplier";
	}
	/**
	 * 前往成交记录页面
	 * @return
	 */
	@RequestMapping("/transactionRecord")
	public String gototransactionRecord() {
		return "transactionRecord";
	}
	/**
	 * 前往会员信息页面
	 * @return
	 */
	@RequestMapping("/vipInfo")
	public String gotovipInfo() {
		return "vipInfo";
	}
}
