package com.demo.restaurantMS.service;

import com.demo.restaurantMS.entity.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    public List<Customer> getAllCustomer();
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(int id);
    public Customer getCustomer(int id);

}
