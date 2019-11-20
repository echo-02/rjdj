package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Shop;
import com.accp.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
   @Autowired
   ShopService ss;
   @RequestMapping("/queryShop")
   @ResponseBody
   public List<Shop> queryShop(Integer userid){
	   return ss.queryShop(userid);
   }
}
