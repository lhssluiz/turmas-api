package com.letscode.turmasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TurmasApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurmasApiApplication.class, args);
    }

}
