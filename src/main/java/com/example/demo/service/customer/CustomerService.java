package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService , UserDetailsService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer save(Customer model) {
        return customerRepository.save(model);
    }

    @Override
    public Customer delete(Customer model) {
        customerRepository.delete(model);
        return model;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = getCustomerByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(customer.getRole());
        UserDetails userDetails = new User(customer.getUsername(), customer.getPassword(), authorities);
        return userDetails;
    }

    @Override
    public Customer getCustomerByUsername(String userName) {
        return customerRepository.findByUsername(userName);
    }
}