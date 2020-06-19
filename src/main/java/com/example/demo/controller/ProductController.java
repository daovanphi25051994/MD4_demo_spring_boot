package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.model.ProductForm;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    @Autowired
   private Environment env;

    @Autowired
    private IProductService productService;

    @GetMapping("/product-form")
    public ModelAndView moveToProductForm(){
        ModelAndView modelAndView = new ModelAndView("product/form");
        modelAndView.addObject("productForm", new ProductForm());
        modelAndView.addObject("message", "");
        return modelAndView;
    }

    @PostMapping("/product/products")
    public ModelAndView saveProduct(@ModelAttribute("productForm") ProductForm productForm){
        ModelAndView modelAndView = new ModelAndView("product/form");
        Product product = new Product(productForm.getName(), null, productForm.getPrice());
        MultipartFile multipartFile = productForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(productForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setAvatar(fileName);
        Product product1 = productService.save(product);
        if (product1 == null){
            modelAndView.addObject("message", "save not successfully!!");
        }else {
            modelAndView.addObject("message", "save successfully!!");
        }
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }
}