package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Jurisdiction;


@RestController
public class VerPermController {

	@PostMapping("/verPerm")
	public List<Jurisdiction> verPerm(String path,HttpSession session) {
		System.out.println("进来ver了");
		List<Jurisdiction> list = (List<Jurisdiction>)session.getAttribute("perm");
		return list;
	}
	
}
