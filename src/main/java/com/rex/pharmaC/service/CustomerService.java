package com.rex.pharmaC.service;

import com.rex.pharmaC.entity.Customer;
import com.rex.pharmaC.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer added successfully to service layer!";
    }


    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }


    public Optional<Customer> getCustomerById(long id) {

        return customerRepository.findById(id);
    }

    public String updateCustomer(Customer customer) {
        Optional<Customer> customerDetails = customerRepository.findById(customer.getCustomerId());
        if(customerDetails.isPresent()){
            customerRepository.save(customer);
            return "Customer is updated in Service Class";
        }
        else {
            return "Customer not  found";
        }
    }


    public String deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return "Customer deleted successfully!";
    }
}
