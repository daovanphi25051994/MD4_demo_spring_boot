package com.example.demo.controller;

import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView moveToCustomersPage(){
        ModelAndView modelAndView = new ModelAndView("customer/customer-list");
        modelAndView.addObject("customers", customerService.getAll());
        return modelAndView;
    }

    @GetMapping("/provinces")
    public ModelAndView moveToProvincesPage(){
        ModelAndView modelAndView = new ModelAndView("province/province-list");
        modelAndView.addObject("provinces", provinceService.getAll());
        return modelAndView;
    }

}