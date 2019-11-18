package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.accp.mapper")
public class JavaSpringboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringboot1Application.class, args);
	}

}
