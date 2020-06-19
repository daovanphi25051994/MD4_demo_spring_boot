package com.example.demo.formatter;

import com.example.demo.model.AppRole;
import com.example.demo.model.Province;
import com.example.demo.service.province.IProvinceService;
import com.example.demo.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RoleFormatter implements Formatter<AppRole> {

    @Autowired
    private IRoleService roleService;


    @Autowired
    public RoleFormatter(IRoleService roleService) {
        this.roleService = roleService;
    }
    @Override
    public AppRole parse(String text, Locale locale) throws ParseException {
        return roleService.getOne(Long.parseLong(text));
    }

    @Override
    public String print(AppRole object, Locale locale) {
        return "[" + object.getId() + " , " + object.getName() + ']';
    }
}