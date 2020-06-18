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
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/customer-form")
    public ModelAndView moveToCustomerForm(){
        ModelAndView modelAndView = new ModelAndView("customer/form");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.getAll());
        return modelAndView;
    }

    @PostMapping("/customer/customers")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        ModelAndView modelAndView = new ModelAndView("customer/form");
        customerService.save(customer);
        modelAndView.addObject("message", "save successfully!!");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
}