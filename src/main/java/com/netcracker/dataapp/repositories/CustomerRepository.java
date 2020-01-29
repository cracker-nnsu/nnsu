package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> getCustomerByPhoneNumber(String phoneNumber);

    @Query("select distinct c from Customer c, Service s where s.customer.id = c.id and s.serviceStatus.id = ?1")
    Iterable<Customer> findAllByServiceStatus_Id(Long serviceStatusId);
}
