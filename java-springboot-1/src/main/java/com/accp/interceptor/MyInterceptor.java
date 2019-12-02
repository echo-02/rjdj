package com.accp.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.accp.domain.Jurisdiction;
import com.accp.domain.User;
import com.accp.service.PositionService;



@Component//让spring容器创建该类对象，表示其它组建
public class MyInterceptor  implements HandlerInterceptor {
	

	/***
	 * 
	 * 执行控制器之前执行该方法，返回false表示不执行控制器
	 * 
	 */
	@Autowired
    PositionService ps;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		    
		   	System.out.println("preHander");
		   	HttpSession session=request.getSession();
		   	List<Jurisdiction> list = (List<Jurisdiction>)session.getAttribute("prem");
		   	User user=(User)session.getAttribute("user");
		   	System.out.println("user:"+user);
		   	if(user==null) {
		   		System.out.println("未登录");
		   		response.sendRedirect("/login");
		   		return false;
		   	}else if(list==null) {
		   		list=ps.findJurisdictionListByPositionId(user.getPositionid());
		   		session.setAttribute("perm", list);
		   		String path=request.getRequestURI();
		   		System.out.println(path);
		   		boolean flag=false;
		   		for (Jurisdiction jurisdiction : list) {
					if(path.equals(jurisdiction.getPath())) {
						System.out.println("有权限...");
						flag=true;
						return true;
					}
				}
		   		System.out.println("没有权限...");
		   		
			    return flag;
		   	}else{
		   		System.out.println("111");
		   		return true;
		   	}
		   	
	}
	
	/**
	 * 
	 * 控制成功执行，没有发生异常情况
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * 不管是否发生异常都会被执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
