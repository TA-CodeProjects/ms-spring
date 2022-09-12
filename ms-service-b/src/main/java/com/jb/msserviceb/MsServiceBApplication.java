package com.jb.msserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MsServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsServiceBApplication.class, args);
	}

}
