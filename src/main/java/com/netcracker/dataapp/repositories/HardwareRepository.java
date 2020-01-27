package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface HardwareRepository extends CrudRepository<Hardware, Long> {
    Iterable<Hardware> findAllByAddress_Id(Long addressId);
    Iterable<Hardware> findAllByService_Id(Long serviceId);
    Iterable<Hardware> findAllByServiceIsNull();
    Iterable<Hardware> findAllByHardwareStatus_Id(Long hardwareStatusId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.customer.id = ?1")
    Iterable<Hardware> findAllFaultyByCustomer_Id(Long customerId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 4 and h.service.customer.id = ?1")
    Iterable<Hardware> findAllToReplaceByCustomer_Id(Long customerId);

    @Query("select h from Hardware h where h.service.customer.id = ?1 and h.hardwareStatus.id = ?2")
    Iterable<Hardware> findAllByCustomer_IdAndHardwareStatus_Id(Long customerId, Long hardwareStatusId);

    @Query("select h from Hardware h where h.hardwareStatus.id = 2 and h.service.id = ?1")
    Iterable<Hardware> findAllFaultyByService_Id(Long serviceId);

    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus.id = ?1 where h.id = ?2")
    int setHardwareStatusByHardware_Id(Long hardwareStatusId, Long hardwareId);

    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus.id = 1 where h.id = ?1")
    int setHardwareStatusNormalByHardware_Id(Long hardwareId);
    @Modifying
    @Transactional
    @Query(value = "update hardware set hardware_status_id = 2 where id = :hardwareId ; update service set service_status_id = 2 where id = (select h.service_id from hardware h where h.id = :hardwareId )", nativeQuery = true)
    int setHardwareStatusFailByHardware_Id(@Param("hardwareId") Long hardwareId);
    @Modifying
    @Transactional
    @Query("update Hardware h set h.hardwareStatus.id = 3 where h.id = ?1")
    int setHardwareStatusUnderMaintByHardware_Id(Long hardwareId);

    @Modifying
    @Transactional
    @Query(value = "update hardware set service_id = (select old_hw.service_id from hardware old_hw where old_hw.id = :oldHardwareId ) where id = :newHardwareId ; update hardware set service_id = null where id = :oldHardwareId ", nativeQuery = true)
    int replaceHardware(@Param("oldHardwareId") Long oldHardwareId, @Param("newHardwareId") Long newHardwareId);
}
