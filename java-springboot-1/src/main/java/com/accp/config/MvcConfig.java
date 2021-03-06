package com.accp.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.accp.interceptor.MyInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	MyInterceptor my;
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
				.addResourceLocations("file:/D:/images");
		super.addResourceHandlers(registry);
	}

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter string = new StringHttpMessageConverter(StandardCharsets.UTF_8);
		converters.add(string);
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new ByteArrayHttpMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(my).addPathPatterns("/*").excludePathPatterns("/images/**","/img/**","/css/**","/fonts/**","/js/**","/layui/**","/vendor/**,015e1a554be28b000001bf7208ef3f.jpg")
		.excludePathPatterns("/login").excludePathPatterns("/none").excludePathPatterns("/authorityManagement");
		super.addInterceptors(registry);
	}

}
