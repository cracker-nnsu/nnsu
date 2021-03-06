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
    @Query(value = "update service set service_status_id = :serviceStatusId where id = :serviceId ; update hardware set hardware_status_id = 2 where id in (select h.id from hardware h where h.service_id = :serviceId and :serviceStatusId = 2 and h.hardware_status_id = 1 limit 1)", nativeQuery = true)
    int setServiceStatusByService_Id(@Param("serviceId") Long serviceId, @Param("serviceStatusId") Long serviceStatusId);

    @Modifying
    @Transactional
    @Query(value = "update service set service_status_id = 2 where id = :serviceId ; update hardware set hardware_status_id = 2 where id in (select h.id from hardware h where h.service_id = :serviceId and h.hardware_status_id = 1 limit 1)", nativeQuery = true)
    int setServiceStatusFailByService_Id(@Param("serviceId") Long serviceId);
}
