package com.accp.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Record;
import com.accp.domain.Vip;
import com.accp.domain.Viplevel;
import com.accp.service.VipService;
import com.accp.service.ViplevelService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="Vip")
public class VipController {

	@Autowired
	private VipService service;
	@Autowired
	private ViplevelService lvservice;
	
	//查询所有Vip
	@RequestMapping(value="/selectAllVip")
	@ResponseBody
	public List<Vip> selectAllVip(){
		return service.selectAllVip();
		
	}
	
	//根据id查询Vip
	
	@RequestMapping(value="/selectVipById/{id}")
	@ResponseBody
	public Vip selectVipById(@PathVariable int id) {
		return service.selectVipById(id);
		
	}
	
	//根据条件查询Vip
	@RequestMapping(value="/selectVipByExample")
	@ResponseBody
	public List<Vip> selectVipByExample(Vip vip){
		return service.selectVipByExample(vip);
		
	}
	
	//分页加条件查询
	@RequestMapping(value="/selectVipByPage")
	@ResponseBody
	public PageInfo<Vip> selectVipByPage(int pageNum,int pageSize, Vip vip){
		PageInfo<Vip> pageinfo = service.selectPage(pageNum, pageSize, vip);
		return pageinfo;
	}
	
	//需要成交记录表的 按会员vipid查询 成交记录次数
	
	
	//新增vip
	@RequestMapping(value="/insertVip")
	@ResponseBody
	public Map<String,String> insertVip(Vip vip){
		Map<String,String> map = new HashMap<>();
		
		service.insertVip(vip);
		map.put("mes", "success");
		return map;
		
	}
	//修改会员
	@RequestMapping(value="/updateVip")
	@ResponseBody
	public Map<String,String> updateVip(Vip vip){
		Map<String,String> map = new HashMap<>();
		//vip.setCheckin(new Date());
		service.updateVip(vip);
		map.put("mes", "success");
		return map;
		
	}
	
	//查询附属消息
	@RequestMapping(value="/selectVipMandC/{id}")
	@ResponseBody
	public Record selectVipMandC(@PathVariable int id){
	
		 
		 if(null==service.selectVipMandC(id)) {
			 Record rc =new Record();
			 rc.setMoney(0.0);;
			 rc.setNumbers(0);
			 return  rc;
		 }else {
				Record rc;
			 rc=service.selectVipMandC(id);
			 return rc;
		 }
	}
	
	//导出文件
	
	@RequestMapping(value="exportExcel")
	public ResponseEntity<byte []> exportExcel(Vip v){
		//需要导入的信息从数据库查询出来
		
	//	v.setVlid(1);
		//v.setName("hyj");
		List<Vip> list= service.selectVipByExample(v);
		//导出信息
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		//表头
		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("姓名");
		titleRow.createCell(1).setCellValue("手机");
		titleRow.createCell(2).setCellValue("等级");
		titleRow.createCell(3).setCellValue("成交次数");
		titleRow.createCell(4).setCellValue("成交金额");
		titleRow.createCell(5).setCellValue("余额");
		titleRow.createCell(6).setCellValue("积分");
		//主体数据
		for(int i=0;i<list.size();i++) {
			Vip vip2 = new Vip();
			vip2=list.get(i);
			
			Row row = sheet.createRow(i+1);
			Cell nameCell = row.createCell(0);
			nameCell.setCellValue(vip2.getName());
			Cell phoneCell = row.createCell(1);
			phoneCell.setCellValue(vip2.getPhone());
			//查等级
			String lv=(lvservice.selectViplevelById(vip2.getVlid())).getLevelname();
			//String lv="白金会员";
			Cell lvidCell = row.createCell(2);
			lvidCell.setCellValue(lv);
			
			//查次数 和查消费
			 if(null==service.selectVipMandC(vip2.getId())) {
				 Record rc =new Record();
				 rc.setMoney(0.0);;
				 rc.setNumbers(0);
				 Cell countCell = row.createCell(3);
				countCell.setCellValue(rc.getNumbers());
				Cell moneyCell = row.createCell(4);
				moneyCell.setCellValue(rc.getMoney());
			 }else {
				 Record rc =new Record();
				 rc=service.selectVipMandC(vip2.getId());
				 Cell countCell = row.createCell(3);
					countCell.setCellValue(rc.getNumbers());
					Cell moneyCell = row.createCell(4);
					moneyCell.setCellValue(rc.getMoney());
			 }
			
			Cell balanceCell = row.createCell(5);
			balanceCell.setCellValue(vip2.getBalance());
			Cell presentCell = row.createCell(6);
			presentCell.setCellValue(vip2.getIntegral());
			
		}
		
		HttpHeaders headers = new HttpHeaders();
		ByteArrayOutputStream bot = new ByteArrayOutputStream();
		try {
			wb.write(bot);
			headers.setContentDispositionFormData("attachment", new String("导出会员信息.xlsx".getBytes("utf-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<byte []>(bot.toByteArray(),headers,HttpStatus.OK);
		
	}
	
	//下载会员导入模板
	@RequestMapping("/download")
	@ResponseBody
	public ResponseEntity<byte []>download(){
		byte[] bytes = null;
		HttpHeaders headers = null;
		try {
			FileInputStream is = new FileInputStream("C:/Users/HYJ/Pictures/moban.xlsx");
			 bytes = new byte[is.available()];
			is.read(bytes);
			 headers = new HttpHeaders();
			headers.setContentDispositionFormData("attachment", new String("会员导入模版.xlsx".getBytes("utf-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		
	}
	//导入会员
	@RequestMapping(value="/excelUpload")
	public String excelUpload(MultipartFile file) {
		try {
			Workbook wb = new XSSFWorkbook(file.getInputStream());
			int sheets = wb.getNumberOfSheets();
			for(int i=0;i<sheets;i++) {
				Sheet sheet =wb.getSheetAt(i);
				int rows =sheet.getPhysicalNumberOfRows();
				for(int j=1;j<rows;j++) {
					Row row =sheet.getRow(j);
					Cell nameCell =row.getCell(0);
					Cell nameCell1 =row.getCell(1);
					Cell nameCell2 =row.getCell(2);
					Cell nameCell3 =row.getCell(3);
					Cell nameCell4 =row.getCell(4);
					Cell nameCell5 =row.getCell(5);
					Cell nameCell6 =row.getCell(6);
					Cell nameCell7 =row.getCell(7);
					Cell nameCell8 =row.getCell(8);
					Vip vip = new Vip();
					vip.setName(nameCell.getStringCellValue());
					//vip.setPhone(String.valueOf(nameCell1.getNumericCellValue()));
					//解决科学计数法
					BigDecimal bdcm = new BigDecimal(nameCell1.getNumericCellValue());
					bdcm.setScale(0, BigDecimal.ROUND_HALF_UP).toPlainString();
					vip.setPhone(String.valueOf(bdcm));
					vip.setProvince(nameCell2.getStringCellValue());
					vip.setCity(nameCell3.getStringCellValue());
					vip.setRegion(nameCell4.getStringCellValue());
					vip.setStreet(nameCell5.getStringCellValue());
					String viplvname=nameCell6.getStringCellValue();
					if(null==lvservice.selectviplvidByname(viplvname)) {
						vip.setVlid(3);
					}else {
						vip.setVlid(lvservice.selectviplvidByname(viplvname));
					}
					
					vip.setBalance(nameCell7.getNumericCellValue());
					vip.setIntegral((int) nameCell8.getNumericCellValue());
					service.insertVip(vip);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/vipInfo";
		
	}
	
	
	
}
