package com.helinfengxs.service_teacher;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.helinfengxs"})
@EnableDiscoveryClient
public class TeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class);
    }
}
