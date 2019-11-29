package com.accp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Goods;
import com.accp.domain.Goodsinstance;
import com.accp.domain.GoodsinstanceExample;
import com.accp.domain.Record;
import com.accp.domain.Recordinstance;
import com.accp.domain.Vip;
import com.accp.domain.VipExample;
import com.accp.domain.Viplevel;
import com.accp.mapper.BalanceMapper;
import com.accp.mapper.GoodsMapper;
import com.accp.mapper.GoodsinstanceMapper;
import com.accp.mapper.RecordMapper;
import com.accp.mapper.RecordinstanceMapper;
import com.accp.mapper.VipMapper;
import com.accp.mapper.ViplevelMapper;

@Service
@Transactional
public class CollectService {
	
	@Autowired
	private GoodsinstanceMapper goodsinstanceMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired 
	private VipMapper vipMapper;
	@Autowired
	private ViplevelMapper viplevelMapper;
	@Autowired 
	private RecordMapper recordMapper;
	@Autowired
	private RecordinstanceMapper recordinstanceMapper;
	@Autowired
	private BalanceMapper balanceMapper;
	
	
	//结算
	public Map<String, String> checkout(String giid, String vipid, String count, String price, String payway) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		String[] giids=giid.split(",");
		String[] counts = count.split(",");
		String[] prices = price.split(",");	
		
		//前台传的商品集合（）
		List<Goodsinstance> listgoodsinstance = new ArrayList<Goodsinstance>();//前台传的goodsints
		for(int i =1 ;i<(giids.length);i++) {
			Goodsinstance goods = new Goodsinstance();
			goods.setGiid(Integer.parseInt(giids[i]));
			goods.setCounts(Integer.parseInt(counts[i]));
			listgoodsinstance.add(goods);
		}
		//后台根据前台的商品查寻的商品集合
		List<Goodsinstance> listgoodsinstfromsql = new ArrayList<Goodsinstance>();//后台根据前台的giid查寻的的goodsints
		for(int i =1 ;i<giids.length;i++) {
			Goodsinstance goods = new Goodsinstance();
			goods= recordMapper.selctGoodsinstsByID((Integer.parseInt(giids[i])));
			listgoodsinstfromsql.add(goods);
		}
		
		
		//查询对应商品主表信息
		List<Goods> listGoods = new ArrayList<Goods>();//查询商品附表对象 相对应的主表信息
		for(int i =1 ;i<giids.length;i++) {
			Goods good = new Goods();
			Goodsinstance goodints = new Goodsinstance();
			goodints= goodsinstanceMapper.selectByPrimaryKey(Integer.parseInt(giids[i]));
			good=goodsMapper.selectByPrimaryKey(goodints.getGid());
			listGoods.add(good);
			}
		//根据数据库价格计算订单总额
		Double Recordtotal = 0.0;	//获取当前订单总金额
		for(int i =1 ;i<giids.length;i++) {
		Double danjia = listGoods.get(i-1).getPrice();
		Double	total = (Integer.parseInt(counts[i]))*danjia;
		Recordtotal+=total;
		}
		//是否为vip
		if(null!=vipid&&!"".equals(vipid)) {
			
		//查询vip信息
		Vip vip = new Vip();//如果vipid 不等于空 则查出vip  
		VipExample vipexam = new VipExample();
		vipexam.createCriteria().andPhoneEqualTo(vipid);
		vip= vipMapper.selectByExample(vipexam).get(0);//获取了会员基本信息
		//获取折扣
		Viplevel viplv= new Viplevel();//获取会员等级信息
		viplv =viplevelMapper.selectByPrimaryKey(vip.getVlid());
		
		
		//进行业务
		
		//1 .查商品库存
		//2.判断是否是会员（余额 ，积分，折扣）（修改）
		//3.支付方式 （先忽略）
		//4.修改商品（库存）
		//4.插入交易记录
		
		
		//1 .查商品库存
		int size=listgoodsinstance.size();
		for(int i = 0 ; i<listgoodsinstance.size(); i++) {
			Integer count1= listgoodsinstance.get(i).getCounts();
			Integer count2= listgoodsinstfromsql.get(i).getCounts();
			if(count1>count2) {
				map.put("mes",listgoodsinstance.get(i).getGiid()+"库存不足" );
				return map;
			}
		}
		
		//2.vip操作
			
		double aftRecordtotal=0.0;//用户最终支付总价（折扣后，抵扣后）
		int Integral = vip.getIntegral();//vip原始积分
		aftRecordtotal=Recordtotal*(viplv.getDiscount()*0.01);//折扣后
		
		//积分抵扣（查看积分是否开启 ，， 为零不进行抵扣）
		int balance = balanceMapper.selectByExample(null).get(0).getBalances();
		if(0==balance) {
			
		}else {
			if(aftRecordtotal>0) {// 如果总价等于0,  不进行积分抵扣  .  积分抵扣大于总价时怎么算       
				//先取余 得到可除整数（100积分以下不抵扣）；
				int chushu =Integral%balance;
				//求取抵扣金额
				if(chushu==0) {
					aftRecordtotal=aftRecordtotal-(Integral/balance);
					vip.setIntegral(0);//积分全部抵扣
				}else {
					aftRecordtotal=aftRecordtotal-((Integral-chushu)/balance);
					vip.setIntegral(chushu);//留下未抵扣的积分
				}
				
				
				//aftRecordtotal=aftRecordtotal-(vip.getIntegral()/100);
				
				if(aftRecordtotal<0) {//如果还是小于0 则抵扣于aftRecordtotal相同的积分  并把应付总金额等于0
					//抵扣相同的积分（加上实际金额*balance 把实际金额设置为0，补上积分）
					 Integral = (int) (vip.getIntegral()-aftRecordtotal*balance); //剩余积分
					//需要设置会员余额积分
					vip.setIntegral(Integral);
					//设置金额为0
					aftRecordtotal=0.0;
				}
			}
		}

		
			//优惠后的订单金额
			//余额，积分更新
		 if(vip.getBalance()>aftRecordtotal) {
			 vip.setBalance(vip.getBalance()-aftRecordtotal);
		 }else {
			 map.put("mes","余额不足");
			 return map;
		 }
		    //修改vip数据
		 vipMapper.updateByPrimaryKey(vip);
		
	
		 	
		
		//3修改商品库存
		 for(int i = 0 ; i<listgoodsinstfromsql.size(); i++) {
				int sqlcounts=listgoodsinstfromsql.get(i).getCounts();//数据库商品数量
				int countfrom = listgoodsinstance.get(i).getCounts();//前台传入商品数量
				listgoodsinstfromsql.get(i).setCounts(sqlcounts-countfrom);//计算后
				GoodsinstanceExample goodinstexam = new GoodsinstanceExample();//跟新数据
				goodinstexam.createCriteria().andGiidEqualTo(listgoodsinstfromsql.get(i).getGiid());
				goodsinstanceMapper.updateByExample(listgoodsinstfromsql.get(i), goodinstexam);
			}
		//4插入交易记录（获取会员信息 ，消费总金额）需要商品主/附表 ！！！用到主从插入
			Record r = new Record();
			r.setMoney(aftRecordtotal);//（记录用户此次订单实际支付价格，积分抵扣已算在内）
			r.setVipid(vip.getId());
			//r.setName(vip.getName());
			//r.setPhone(vip.getPhone());
			r.setTradedate(new Date());
			recordMapper.insertSelective(r);
			
			Integer recordReturnId=r.getId();//获取主表返回id
			//!!!!此时 记录附表 的价格 是否是 储存的打折后的 价格 （根据listgoodsinstfromsql 的单价 和listgoodsinstance 的数量 乘积 在乘以 会员折扣或者{无会员}） 
			for(int i=0 ; i<listgoodsinstfromsql.size();i++) {//可能有多个商品，要插入多条附表记录
				Recordinstance rinsts = new Recordinstance();
				rinsts.setGid(listGoods.get(i).getGid());//设置商品id
				rinsts.setBarcode(listgoodsinstfromsql.get(i).getBarcode());//设置条形码
				rinsts.setRid(recordReturnId);//设置Record主表 关联
				rinsts.setNumbers(listgoodsinstance.get(i).getCounts());//设置商品数量
				rinsts.setPrice(listGoods.get(i).getPrice()*(viplv.getDiscount()*0.01));//设置每一个商品单价(打折后，积分抵扣不算在内)
				rinsts.setArtno(listGoods.get(i).getArtno());//设置商品货号
				recordinstanceMapper.insert(rinsts);
			}
			map.put("money", String.valueOf(aftRecordtotal));
			
		}else {//不是会员
			//1 .查商品库存
			int size=listgoodsinstance.size();
			for(int i = 0 ; i<listgoodsinstance.size(); i++) {
				Integer count1= listgoodsinstance.get(i).getCounts();
				Integer count2= listgoodsinstfromsql.get(i).getCounts();
				if(count1>count2) {
					map.put("mes",listgoodsinstance.get(i).getGiid()+"库存不足" );
					return map;
				}
			}
			
			//3修改商品库存
			 for(int i = 0 ; i<listgoodsinstfromsql.size(); i++) {
					int sqlcounts=listgoodsinstfromsql.get(i).getCounts();//数据库商品数量
					int countfrom = listgoodsinstance.get(i).getCounts();//前台传入商品数量
					listgoodsinstfromsql.get(i).setCounts(sqlcounts-countfrom);//计算后
					GoodsinstanceExample goodinstexam = new GoodsinstanceExample();//跟新数据
					goodinstexam.createCriteria().andGiidEqualTo(listgoodsinstfromsql.get(i).getGiid());
					goodsinstanceMapper.updateByExample(listgoodsinstfromsql.get(i), goodinstexam);
				}
			 
			//4插入交易记录（获取会员信息 ，消费总金额）需要商品主/附表 ！！！用到主从插入
				Record r = new Record();
				r.setMoney(Recordtotal);
				//r.setVipid(vip.getId());
				//r.setName(vip.getName());
				//r.setPhone(vip.getPhone());
				r.setTradedate(new Date());
				recordMapper.insertSelective(r);
				
				Integer recordReturnId=r.getId();//获取主表返回id
				//!!!!此时 记录附表 的价格 是否是 储存的打折后的 价格 （根据listgoodsinstfromsql 的单价 和listgoodsinstance 的数量 乘积 在乘以 会员折扣或者{无会员}） 
				for(int i=0 ; i<listgoodsinstfromsql.size();i++) {//可能有多个商品，要插入多条附表记录
					Recordinstance rinsts = new Recordinstance();
					rinsts.setGid(listGoods.get(i).getGid());//设置商品id
					rinsts.setBarcode(listgoodsinstfromsql.get(i).getBarcode());//设置条形码
					rinsts.setRid(recordReturnId);//设置Record主表 关联
					rinsts.setNumbers(listgoodsinstance.get(i).getCounts());//设置商品数量
					rinsts.setPrice(listGoods.get(i).getPrice());//设置商品单价
					rinsts.setArtno(listGoods.get(i).getArtno());//设置商品货号
					recordinstanceMapper.insert(rinsts);
					map.put("money", String.valueOf(Recordtotal));
		}
	}//else
		return map;
		
		
		
	}

	
}
