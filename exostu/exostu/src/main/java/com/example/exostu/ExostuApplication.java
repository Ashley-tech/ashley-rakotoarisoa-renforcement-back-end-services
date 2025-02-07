package com.example.exostu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.example.exostu")
@EnableMongoRepositories(basePackages = "com.example.exostu.repository")
@EntityScan(basePackages = "com.example.exostu.document")
@EnableDiscoveryClient
@EnableFeignClients
public class ExostuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExostuApplication.class, args);
	}

}
