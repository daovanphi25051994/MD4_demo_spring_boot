package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/province-form")
    public ModelAndView moveToProvinceForm(){
        ModelAndView modelAndView = new ModelAndView("province/form");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/province/provinces")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province){
        ModelAndView modelAndView = new ModelAndView("province/form");
        provinceService.save(province);
        modelAndView.addObject("message", "save successfully!!");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }
}