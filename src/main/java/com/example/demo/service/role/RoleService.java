package com.example.demo.service.role;

import com.example.demo.model.AppRole;
import com.example.demo.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<AppRole> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public AppRole getOne(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public AppRole save(AppRole model) {
        return roleRepository.save(model);
    }

    @Override
    public AppRole delete(AppRole model) {
       roleRepository.delete(model);
        return model;
    }
}