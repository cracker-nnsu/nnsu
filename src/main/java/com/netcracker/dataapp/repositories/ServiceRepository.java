package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.Customer;
import com.netcracker.dataapp.entities.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    Iterable<Service> findAllByCustomer(Customer customer);
    Iterable<Service> findAllByCustomer_Id(Long customerId);

    @Modifying
    @Transactional
    @Query("update Service s set s.serviceStatus.id = 2 where s.customer.id = ?1 and s.id = ?2")
    void setServiceStatusFailByCustomer_IdAndService_Id(Long customerId, Long serviceId);
}
