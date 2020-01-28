package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    Iterable<Service> findAllByCustomer_Id(Long customerId);
    Iterable<Service> findAllByServiceStatus_Id(Long serviceStatusId);

    @Modifying
    @Transactional
    @Query("update Service s set s.serviceStatus.id = ?1 where s.customer.id = ?2 and s.id = ?3")
    int setServiceStatusByCustomer_IdAndService_Id(Long serviceStatusId, Long customerId, Long serviceId);

    @Modifying
    @Transactional
    @Query(value = "update service set service_status_id = 2 where customer_id = :customerId and id = :serviceId ; update hardware set hardware_status_id = 2 where service_id = :serviceId order by RAND() limit 1", nativeQuery = true)
    int setServiceStatusFailByCustomer_IdAndService_Id(@Param("customerId") Long customerId, @Param("serviceId") Long serviceId);
}
