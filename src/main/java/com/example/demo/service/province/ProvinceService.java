package com.example.demo.service.province;

import com.example.demo.model.Province;
import com.example.demo.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public List<Province> getAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province getOne(Long id) {
        return provinceRepository.getOne(id);
    }

    @Override
    public Province save(Province model) {
        return provinceRepository.save(model);
    }

    @Override
    public Province delete(Province model) {
        provinceRepository.delete(model);
        return model;
    }
}