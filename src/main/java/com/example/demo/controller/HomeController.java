package com.example.demo.controller;

import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.product.IProductService;
import com.example.demo.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

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

    @GetMapping("/products")
    public ModelAndView moveToProductsPage(){
        ModelAndView modelAndView = new ModelAndView("product/product-list");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView moveToLoginPage(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView("customer/customer-list");
        return modelAndView;
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

}