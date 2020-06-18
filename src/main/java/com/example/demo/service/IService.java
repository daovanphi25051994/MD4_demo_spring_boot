package com.example.demo.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T getOne(Long id);
    T save(T model);
    T delete(T model);
}
