package com.demo.restaurantMS.service.impl;

import com.demo.restaurantMS.entity.Customer;
import com.demo.restaurantMS.repository.CustomerRepository;
import com.demo.restaurantMS.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerServiceImpl(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        if(customerRepo.findById(id).isPresent()){
            try {
                customerRepo.deleteById(id);
                log.info("Successfully deleted!");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else {
            log.info("Customer not found");
        }
    }

    @Override
    public Customer getCustomer(int id) {
        Optional<Customer>  customerOptional = customerRepo.findById(id);
        return customerOptional.orElse(null);
    }

}
