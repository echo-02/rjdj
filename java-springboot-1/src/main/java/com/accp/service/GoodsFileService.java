package com.accp.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.Classification;
import com.accp.domain.ClassificationExample;
import com.accp.domain.Goods;
import com.accp.domain.GoodsExample;
import com.accp.domain.Goodsinstance;
import com.accp.domain.GoodsinstanceExample;
import com.accp.domain.Specificationdetails;
import com.accp.domain.SpecificationdetailsExample;
import com.accp.mapper.ClassificationMapper;
import com.accp.mapper.GoodsMapper;
import com.accp.mapper.GoodsinstanceMapper;
import com.accp.mapper.SpecificationdetailsMapper;

@Service
@Transactional
public class GoodsFileService {
	@Autowired
	private ClassificationMapper classificationMapper;
	@Autowired
	private SpecificationdetailsMapper specificationdetailsMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsinstanceMapper goodsinstanceMapper;
	/**
	 * 下载Excel模板
	 * @return
	 * @throws IOException 
	 */
	public ResponseEntity<byte []> downloadGoodsExcel() throws IOException {
		FileInputStream is = new FileInputStream("/D:/Y2/template.xlsx");
		byte[] bytes = new byte[is.available()];
		is.read(bytes);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", new String("商品导入模版.xlsx".getBytes("utf-8"),"iso-8859-1"));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
	}
	/**
	 * 导出商品
	 * @param gids
	 * @return
	 * @throws IOException
	 */
	public ResponseEntity<byte []> pullOut(List<Integer> gids) throws IOException{
		//查询出需要导出的信息
		List<Goods> goods=goodsMapper.getGoods(null, null, gids);
		//导出信息为excel
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("货号");
		titleRow.createCell(1).setCellValue("条形码");
		titleRow.createCell(2).setCellValue("名称");
		titleRow.createCell(3).setCellValue("类别");
		titleRow.createCell(4).setCellValue("品牌");
		titleRow.createCell(5).setCellValue("成本价");
		titleRow.createCell(6).setCellValue("出售价");
		titleRow.createCell(7).setCellValue("规格");
		titleRow.createCell(8).setCellValue("数量");
		int i=1;
		//循环生成行
		for (Goods goodsE : goods) {
			List<Goodsinstance> goodsinstances=goodsE.getGoodsinstances();
			for (Goodsinstance goodsinstance : goodsinstances) {
				Row row = sheet.createRow(i);
				Cell artnoCell = row.createCell(0);
				artnoCell.setCellValue(goodsE.getArtno());
				Cell barcodeCell = row.createCell(1);
				barcodeCell.setCellValue(goodsinstance.getBarcode());
				Cell gnameCell = row.createCell(2);
				gnameCell.setCellValue(goodsE.getGname());
				Cell cfnameCell = row.createCell(3);
				cfnameCell.setCellValue(goodsE.getCfname());
				Cell brandCell = row.createCell(4);
				brandCell.setCellValue(goodsE.getBrand());
				Cell costCell = row.createCell(5);
				costCell.setCellValue(goodsE.getCost());
				Cell priceCell = row.createCell(6);
				priceCell.setCellValue(goodsE.getPrice());
				Cell colorCell = row.createCell(7);
				colorCell.setCellValue(goodsinstance.getSpec());
				Cell countCell = row.createCell(8);
				countCell.setCellValue(goodsinstance.getCounts());
				i++;
			}
		}
		HttpHeaders headers = new HttpHeaders();
		ByteArrayOutputStream bot = new ByteArrayOutputStream();
		wb.write(bot);
		headers.setContentDispositionFormData("attachment", new String("导出的商品信息.xlsx".getBytes("utf-8"),"iso-8859-1"));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(bot.toByteArray(), headers, HttpStatus.OK);
	}
	/**
	 * 上传商品
	 * @param file
	 * @return
	 */
	public int goodsFileUpload(MultipartFile file) {
		int in=0;
		try {
			//将传入的文件转换成excel
			Workbook wb = new XSSFWorkbook(file.getInputStream());
			//获取sheet业的个数
			int sheets = wb.getNumberOfSheets();
			for(int i=0;i<sheets;i++) {
				//根据下标获取sheet页
				Sheet sheet = wb.getSheetAt(i);
				//获取当前sheet页的行数
				int rows = sheet.getPhysicalNumberOfRows();
				//要新增的商品
				Goods goods=new Goods();
				List<Goodsinstance> goodsinstances=new ArrayList<Goodsinstance>();
				//新增的商品编号
				List<Integer> gids=new ArrayList<Integer>();
				for(int j=1;j<rows;j++) {
					//根据下标获取行
					Row row = sheet.getRow(j);
					//是否跳过当前行标识
					boolean cf=false;
					for (Cell cell : row) {
						if(cell==null||cell.equals("")||cell.getCellType()==CellType.BLANK) {
							cf=true;
							break;
						}
					}
					if(cf) {
						continue;
					}
					Cell artnoCell = row.getCell(0);
					Cell barcodeCell = row.getCell(1);
					Cell gnameCell = row.getCell(2);
					Cell cfnameCell = row.getCell(3);
					Cell brandCell = row.getCell(4);
					Cell costCell = row.getCell(5);
					Cell priceCell = row.getCell(6);
					Cell colorCell = row.getCell(7);
					Cell sizeCell = row.getCell(8);
					Cell countCell = row.getCell(9);
					//获取值
					String artno=artnoCell.getStringCellValue().toString().trim();
					String barcode=barcodeCell.getStringCellValue().toString().trim();
					String gname=gnameCell.getStringCellValue().toString().trim();
					String cfname=cfnameCell.getStringCellValue().toString().trim();
					String brand=brandCell.getStringCellValue().toString().trim();
					String color=colorCell.getStringCellValue().toString().trim();
					String size=sizeCell.getStringCellValue().toString().trim();
					Double cost=costCell.getNumericCellValue();
					Double price=priceCell.getNumericCellValue();
					Integer count=(int) countCell.getNumericCellValue();
					//需要的值
					Integer cfid=null;
					Integer status=0;
					StringBuilder sfdids=new StringBuilder();
					//查询或新增类别
					Classification classification=new Classification();
					ClassificationExample classificationExample=new ClassificationExample();
					classificationExample.createCriteria().andCfnameEqualTo(cfname);
					List<Classification> classifications=classificationMapper.selectByExample(classificationExample);
					if(classifications==null||classifications.size()<=0) {
						classification.setCfname(cfname);
						classification.setStatus(0);
						classificationMapper.insertSelective(classification);
					}else {
						classification=classifications.get(0);
					}
					cfid=classification.getCfid();
					//查询或新增规格
					Specificationdetails colorSp=getSpecificationdetails(color,1);
					Specificationdetails sizeSp=getSpecificationdetails(size,2);
					sfdids.append(colorSp.getSfdid());
					sfdids.append(",");
					sfdids.append(sizeSp.getSfdid());
					//当第一次运行到这时设置商品实体
					if(goods.getArtno()==null) {
						goods.setArtno(artno);
						goods.setBrand(brand);
						goods.setCfid(cfid);
						goods.setCost(cost);
						goods.setPrice(price);
						goods.setGname(gname);
						goods.setStatus(0);
					}
					//当货号一致时设置详情并新增商品，保存商品编号
					if(goods.getArtno().equals(artno)) {
						saveGoods(goods, gids, barcode, count, sfdids);
					}
					//当货号不一致时，重置商品
					else {
						goods=new Goods();
						goods.setArtno(artno);
						goods.setBrand(brand);
						goods.setCfid(cfid);
						goods.setCost(cost);
						goods.setPrice(price);
						goods.setGname(gname);
						goods.setStatus(0);
						saveGoods(goods, gids, barcode, count, sfdids);
					}
				}
				//更新商品库存
				for (Integer gid : gids) {
					in=goodsMapper.updateCount(gid);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	/**
	 * 保存商品
	 * @param goods
	 * @param gids
	 * @param barcode
	 * @param count
	 * @param sfdids
	 */
	private void saveGoods(Goods goods, List<Integer> gids, String barcode, Integer count, StringBuilder sfdids) {
		GoodsExample goodsExample=new GoodsExample();
		goodsExample.createCriteria().andArtnoEqualTo(goods.getArtno());
		//根据货号查询信息，若没有则新增
		if(goodsMapper.selectByExample(goodsExample).size()==0) {
			goodsMapper.insertSelective(goods);
			gids.add(goods.getGid());
		}
		if(goods.getGid()!=null) {
			Goodsinstance goodsinstance=new Goodsinstance();
			goodsinstance.setBarcode(barcode);
			goodsinstance.setCounts(count);
			goodsinstance.setGid(goods.getGid());
			goodsinstance.setSfdids(sfdids.toString());
			//根据条形码查询信息，若没有则新增
			GoodsinstanceExample goodsinstanceExample=new GoodsinstanceExample();
			goodsinstanceExample.createCriteria().andBarcodeEqualTo(goodsinstance.getBarcode());
			if(goodsinstanceMapper.selectByExample(goodsinstanceExample).size()==0) {
				goodsinstanceMapper.insertSelective(goodsinstance);
			}
		}
	}
	/**
	 * 查询或新增规格
	 * @param sfdname 规格名称
	 * @param sfid	父类规格编号
	 * @return
	 */
	private Specificationdetails getSpecificationdetails(String sfdname,Integer sfid) {
		SpecificationdetailsExample specificationdetailsExample=new SpecificationdetailsExample();
		specificationdetailsExample.createCriteria().andSfdnameEqualTo(sfdname);
		List<Specificationdetails> specificationdetails=specificationdetailsMapper.selectByExample(specificationdetailsExample);
		if(specificationdetails.size()>0) {
			return specificationdetails.get(0);
		}else {
			Specificationdetails specificationdetail=new Specificationdetails();
			specificationdetail.setSfdname(sfdname);
			specificationdetail.setSfid(sfid);
			specificationdetailsMapper.insertSelective(specificationdetail);
			return specificationdetail;
		}
	}
}
