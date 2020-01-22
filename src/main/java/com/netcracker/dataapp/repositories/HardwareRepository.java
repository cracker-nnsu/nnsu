package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HardwareRepository extends CrudRepository<Hardware, Long> {
    Iterable<Hardware> findAllByAddress(Address address);
    Iterable<Hardware> findAllByAddress_Id(Long addressId);
    Iterable<Hardware> findAllByService(Service service);
    Iterable<Hardware> findAllByService_Id(Long serviceId);
    Iterable<Hardware> findAllByServiceIsNull();
    Iterable<Hardware> findAllByHardwareStatus(HardwareStatus hardwareStatus);
    Iterable<Hardware> findAllByHardwareStatus_Id(Long hardwareStatusId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.customer = ?1")
    Iterable<Hardware> findAllFaultyByCustomer(Customer customer);
    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.customer.id = ?1")
    Iterable<Hardware> findAllFaultyByCustomer_Id(Long customerId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 4 and h.service.customer = ?1")
    Iterable<Hardware> findAllToReplaceByCustomer(Customer customer);
    @Query("select h from Hardware h where h.hardwareStatus.id = 4 and h.service.customer.id = ?1")
    Iterable<Hardware> findAllToReplaceByCustomer_Id(Long customerId);

    @Query("select h from Hardware h where h.service.customer = ?1 and h.hardwareStatus.id = ?2")
    Iterable<Hardware> findAllByCustomerAndHardwareStatus(Customer customer, HardwareStatus hardwareStatus);
    @Query("select h from Hardware h where h.service.customer.id = ?1 and h.hardwareStatus.id = ?2")
    Iterable<Hardware> findAllByCustomer_IdAndHardwareStatus_Id(Long customerId, Long hardwareStatusId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service = ?1")
    Iterable<Hardware> findAllFaultyByService(Service service);
    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.id = ?1")
    Iterable<Hardware> findAllFaultyByService_Id(Long serviceId);

    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus = ?1 where h = ?2")
    void setHardwareStatusByHardware(HardwareStatus hardwareStatus, Hardware hardware);
    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus.id = ?1 where h.id = ?2")
    void setHardwareStatusByHardware_Id(Long hardwareStatusId, Long hardwareId);

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
    @Query(value = "update hardware set service_id = (select old_hw.service_id from hardware old_hw where old_hw.id = ?1) where id = ?2; update hardware set service_id = null where id = ?1", nativeQuery = true)
    void replaceHardware(Long oldHardwareId, Long newHardwareId);
}
