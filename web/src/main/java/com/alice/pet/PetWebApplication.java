package com.alice.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetWebApplication.class, args);
    }
}
