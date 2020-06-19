//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.resource.PathResourceResolver;
//
//import java.io.IOException;
//
//@Configuration
//@EnableWebMvc
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Autowired
//    Environment env;
//
//    //Config FileUpload
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSizePerFile(5242880);//5MB
//        return resolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String fileUpload = env.getProperty("file_upload").toString();
//        registry
//                .addResourceHandler("/i/**")
//                .addResourceLocations("file:" + fileUpload)
//                .setCachePeriod(3600)
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver());
//    }
//}