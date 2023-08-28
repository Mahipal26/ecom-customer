package com.ecom.customer.service.impl;

import com.ecom.customer.client.OrdersAPI;
import com.ecom.customer.dto.CustomerResponse;
import com.ecom.customer.dto.Orders;
import com.ecom.customer.entity.Customers;
import com.ecom.customer.repository.CustomerRepository;
import com.ecom.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    OrdersAPI ordersAPI;


    @Override
    public List<Customers> getCustomers() {
        return repository.findAll();
    }

    @Override
    public CustomerResponse getCustomerOrders(int id) {

        Customers customer = repository.findByCustomerNumber(id);
        List<Orders> orders = ordersAPI.getOrdersByCustomer(id);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setOrders(orders);
        return customerResponse;
    }
}
