package com.ecom.customer.repository;

import com.ecom.customer.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {
    Customers findByCustomerNumber(int id);
}
