package com.maxrocky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.maxrocky.repository")
public class VisualCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisualCloudApplication.class, args);
	}

}
