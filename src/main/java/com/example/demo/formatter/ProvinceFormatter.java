package com.example.demo.formatter;

import com.example.demo.model.Province;
import com.example.demo.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.getOne(Long.parseLong(text));
    }

    @Override
    public String print(Province province, Locale locale) {
        return "[" + province.getId() + " , " + province.getName() + ']';
    }
}