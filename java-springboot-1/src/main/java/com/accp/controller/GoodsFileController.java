package com.accp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.service.GoodsFileService;

@Controller
@RequestMapping("/goodsFile")
public class GoodsFileController {
	@Autowired
	private GoodsFileService fileService;
	/**
	 * 下载Excel模板
	 * @return
	 */
	@RequestMapping("/downloadGoodsExcel")
	@ResponseBody
	public ResponseEntity<byte []> downloadGoodsExcel() {
		try {
			return fileService.downloadGoodsExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 导出商品
	 * @param gids
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pullOut")
	@ResponseBody
	public ResponseEntity<byte []> pullOut(String giids){
		List<Integer> list=new ArrayList<Integer>();
		String[] giid =giids.split(",");
		for (String string : giid) {
			Integer id=Integer.parseInt(string);
			list.add(id);
		}
		try {
			return fileService.pullOut(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 上传商品
	 * @param file
	 * @return
	 */
	@RequestMapping("/goodsFileUpload")
	@ResponseBody
	public int goodsFileUpload(MultipartFile file) {
		return fileService.goodsFileUpload(file);
	}
}
