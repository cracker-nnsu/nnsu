package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.Address;
import com.netcracker.dataapp.entities.Customer;
import com.netcracker.dataapp.entities.Hardware;
import com.netcracker.dataapp.entities.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HardwareRepository extends CrudRepository<Hardware, Long> {
    Iterable<Hardware> findAllByAddress(Address address);
    Iterable<Hardware> findAllByAddress_Id(Long addressId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.customer = ?1")
    Iterable<Hardware> findAllFaultyByCustomer(Customer customer);
    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.customer.id = ?1")
    Iterable<Hardware> findAllFaultyByCustomer_Id(Long customerId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service = ?1")
    Iterable<Hardware> findAllFaultyByService(Service service);
    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.id = ?1")
    Iterable<Hardware> findAllFaultyByService_Id(Long serviceId);

    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus.id = 1 where h.id = ?1")
    void setHardwareStatusNormalByHardware_Id(Long hardwareId);
    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus.id = 3 where h.id = ?1")
    void setHardwareStatusMaintenanceByHardware_Id(Long hardwareId);

    @Modifying
    @Transactional
    @Query(value = "update hardware set service_id = null where id = ?1 ; update hardware set service_id = ?2 where id = ?3", nativeQuery = true)
    void replaceHardware(Long oldHardwareId, Long serviceId, Long newHardwareId);
}
