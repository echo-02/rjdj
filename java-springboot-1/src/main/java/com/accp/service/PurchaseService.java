package com.accp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Purchase;
import com.accp.domain.PurchaseExample;
import com.accp.domain.Purchaseinstance;
import com.accp.domain.PurchaseinstanceExample;
import com.accp.mapper.GoodsMapper;
import com.accp.mapper.GoodsinstanceMapper;
import com.accp.mapper.PurchaseMapper;
import com.accp.mapper.PurchaseinstanceMapper;

@Service
@Transactional
public class PurchaseService {
	@Autowired
	private PurchaseMapper purchaseMapper;
	@Autowired
	private PurchaseinstanceMapper purchaseinstanceMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsinstanceMapper goodsinstanceMapper;
	/**
	 * 自动生成订单号
	 * @return
	 */
	public String getPurchaseId() {
		String id="";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		String dateStr=dateFormat.format(new Date());
		PurchaseExample purchaseExample=new PurchaseExample();
		purchaseExample.createCriteria().andIdLike("%"+dateStr+"%");
		List<Purchase> purchases=purchaseMapper.selectByExample(purchaseExample);
		Integer purNum=purchases.size();
		id+=dateStr;
		String num=purNum.toString();
		for (int i = num.length(); i < 3; i++) {
			id+="0";
		}
		id+=++purNum;
		return id;
	}
	/**
	 * 保存采购信息
	 * @param purchase
	 * @return
	 */
	public int savePurchase(Purchase purchase) {
		int i=0;
		Purchase ckpurchase=purchaseMapper.selectByPrimaryKey(purchase.getId());
		if(ckpurchase==null) {
			i=purchaseMapper.insertSelective(purchase);
		}else {
			i=purchaseMapper.updateByPrimaryKeySelective(purchase);
			PurchaseinstanceExample purchaseinstanceExample=new PurchaseinstanceExample();
			purchaseinstanceExample.createCriteria().andPidEqualTo(purchase.getId());
			purchaseinstanceMapper.deleteByExample(purchaseinstanceExample);
		}
		List<Purchaseinstance> purchaseinstances=purchase.getPurchases();
		purchaseinstanceMapper.addEach(purchaseinstances, purchase.getId());
		return i;
	}
	/**
	 * 判断采购单号是否存在
	 * @param pid
	 * @return
	 */
	public boolean ckPid(String pid) {
		boolean f=false;
		Purchase purchase=purchaseMapper.selectByPrimaryKey(pid);
		if(purchase!=null) {
			f=true;
		}
		return f;
	}
	/**
	 * 查询采购单列表
	 * @param startseachtime
	 * @param endseachtime
	 * @return
	 */
	public List<Purchase> getPurchase(String startseachtime,String endseachtime,String sname) {
		return purchaseMapper.getPurchase(startseachtime, endseachtime,sname);
	}
	public Purchase getPurchaseById(String id) {
		return purchaseMapper.selectByPrimaryKey(id);
	}
	/**
	 * 查询采购单详情
	 * @param pid
	 * @return
	 */
	public List<Purchaseinstance> getPurinsByPid(String pid) {
		return purchaseinstanceMapper.getPurinsByPid(pid);
	}
	/**
	 * 审核采购单
	 * @param id
	 * @return
	 */
	public int checkPurchase(String id) {
		int i=0;
		Purchase purchase=new Purchase();
		purchase.setId(id);
		purchase.setStatus(1);
		i=purchaseMapper.updateByPrimaryKeySelective(purchase);
		//存放被修改的商品详情编号
		List<Integer> list=new ArrayList<Integer>();
		//修改商品详情数量
		List<Purchaseinstance> purchaseinstances=purchaseinstanceMapper.getPurinsByPid(id);
		for (Purchaseinstance purchaseinstance : purchaseinstances) {
			Integer giid=purchaseinstance.getGid();
			Integer num=purchaseinstance.getNumbers();
			goodsinstanceMapper.changeXQNum(num, giid);
			list.add(giid);
		}
		//存放被修改的商品编号
		List<Integer> gids=goodsMapper.getChangedIds(list);
		//更新库存
		for (Integer integer : gids) {
			goodsMapper.updateCount(integer);
		}
		return i;
	}
}
