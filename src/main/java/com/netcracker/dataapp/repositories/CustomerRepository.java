package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> getCustomerByPhoneNumber(String phoneNumber);
}
