package com.rex.pharmaC.controller;

import com.rex.pharmaC.entity.Customer;
import com.rex.pharmaC.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;




    @PostMapping
    @Operation(
            summary = "Create a new Customer",
            description = "This is an API to create a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "added successfully"),
            @ApiResponse(responseCode = "500", description = "FAILURE")
    })
    public String addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable long id){

        return customerService.getCustomerById(id);
    }

    @PutMapping
    public String updateCustomer(@RequestBody Customer customer){

        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
        public String deleteCustomer(@PathVariable long id){

        return customerService.deleteCustomer(id);
    }


}
