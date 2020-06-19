package com.example.demo.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


public class ProductForm {

    private Long id;

    private String name;

    private MultipartFile avatar;

    private float price;

    public ProductForm() {
    }

    public ProductForm(Long id, String name, MultipartFile avatar, float price) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}