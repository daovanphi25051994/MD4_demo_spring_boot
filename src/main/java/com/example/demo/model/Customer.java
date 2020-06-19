package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;



    @ManyToOne
    private Province province;

    @ManyToOne
    private AppRole role;

    public Customer() {
    }

    public Customer(Long id, String username, String password, Province province, AppRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.province = province;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }
}