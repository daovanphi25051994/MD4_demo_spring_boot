package com.example.demo;

import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.province.IProvinceService;
import com.example.demo.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

//    //Config FileUpload
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//
//        //Set the maximum allowed size (in bytes) for each individual file.
//        resolver.setMaxUploadSizePerFile(5242880);//5MB
//
//        //You may also set other available properties.
//
//        return resolver;
//    }

//    @Autowired
//   public Environment env;

    // Cấu hình để sử dụng các file nguồn tĩnh (css, image, js..)
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        String fileUpload = env.getProperty("file_upload").toString();
//
//        // Image resource.
//        registry.addResourceHandler("/i/**") //
//                .addResourceLocations("file:" + fileUpload);
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
