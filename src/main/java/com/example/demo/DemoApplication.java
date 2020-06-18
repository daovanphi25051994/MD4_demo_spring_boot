package com.example.demo;

import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.province.IProvinceService;
import com.example.demo.service.province.ProvinceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public ICustomerService customerService(){
        return new CustomerService();
    }

    @Bean
    public IProvinceService provinceService(){
        return new ProvinceService();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
