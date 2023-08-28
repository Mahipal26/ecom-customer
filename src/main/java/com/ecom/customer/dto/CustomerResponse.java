package com.ecom.customer.dto;

import com.ecom.customer.entity.Customers;

import java.util.List;

public class CustomerResponse extends Customers{

    List<Orders> orders;


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
