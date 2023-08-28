package com.ecom.customer.controller;

import com.ecom.customer.dto.CustomerResponse;
import com.ecom.customer.entity.Customers;
import com.ecom.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customers> getAllCustomers(){
        return service.getCustomers();
    }

    @GetMapping(value = "/customers/{id}/orders")
    public CustomerResponse getCustomerOrders(@PathVariable int id){

        return service.getCustomerOrders(id);

    }



}
