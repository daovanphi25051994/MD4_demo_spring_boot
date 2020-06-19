package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product save(Product model) {
        return productRepository.save(model);
    }

    @Override
    public Product delete(Product model) {
        productRepository.delete(model);
        return model;
    }
}