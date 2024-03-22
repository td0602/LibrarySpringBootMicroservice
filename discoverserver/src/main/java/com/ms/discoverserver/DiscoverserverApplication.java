package com.ms.discoverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
// được sử dụng trong kiến trúc microservices để quản lý và giám sát các service.
@EnableEurekaServer // đánh dấu là một ứng dụng Spring Boot Eureka Server
@SpringBootApplication
public class DiscoverserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverserverApplication.class, args);
	}

}
