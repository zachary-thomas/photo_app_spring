package com.photoapp.api.account.PhotoAppApiAccountManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountManagementApplication.class, args);
	}

}
