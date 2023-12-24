package com.example.springredisdistributedlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // That is used to enable the scheduling of tasks in a Spring application.
public class SpringRedisDistributedLockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisDistributedLockApplication.class, args);
	}

}
