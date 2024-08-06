package com.intuit.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.intuit.auction")
@EnableFeignClients
@Configuration
public class AuctionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuctionServiceApplication.class, args);
    }
}
