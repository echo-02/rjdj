package com.accp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Record;
import com.accp.mapper.RecordMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class RecordService {
	
	@Autowired
	private RecordMapper mapper;
	
	//跟据条件查询充值抵扣页面
		public List<Record> selectAllRecord(Record t){
			return mapper.selectAllRecord(t);
			
		}
	//跟据条件查询充值抵扣页面
			public List<Record> selectAllRecordByP(Record t){
				return mapper.selectAllRecordByP(t);
				
			}	
		
		//分页
		public PageInfo<Record> selectRecordBypage(int pageNum,int pageSize,Record r, String time,int status){

			if (time != "" && time != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
				try {
					r.setTradedate(dateFormat.parse(time.substring(0, 10)));
					r.setTradedate2(dateFormat.parse(time.substring(22, 32)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				r.setTradedate(null);
				r.setTradedate2(null);
			}

			if (r.getName() == "") {
				r.setName(null);
			}
			PageHelper.startPage(pageNum, pageSize);
			List<Record> list;
			if(status==0) {
				 list = this.selectAllRecord(r);
			}else {
				 list = this.selectAllRecordByP(r);
			}
			PageInfo<Record> pageinfo = new PageInfo<>(list);
			return pageinfo;
			
		}
}
