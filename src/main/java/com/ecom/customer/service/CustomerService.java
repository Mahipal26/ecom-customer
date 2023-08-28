package com.ecom.customer.service;


import com.ecom.customer.dto.CustomerResponse;
import com.ecom.customer.entity.Customers;

import java.util.List;


public interface CustomerService {

    List<Customers> getCustomers();

    CustomerResponse getCustomerOrders(int id);
}
