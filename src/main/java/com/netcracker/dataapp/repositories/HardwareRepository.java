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
    @Query(value = "update hardware set hardware_status_id = :hardwareStatusId where id = :hardwareId ; update service set service_status_id = :hardwareStatusId where id = (select h.service_id from hardware h where h.id = :hardwareId and (not exists (select h2.id from hardware h2 where h2.service_id = h.service_id and h2.hardware_status_id <> 1) or :hardwareStatusId <> 1 )) ; update customer set customer_status_id = decode( :hardwareStatusId , 1, 1, 2, 2, 3, 2, 4, 2) where id = (select s.customer_id from service s where s.id = (select service_id from hardware where id = :hardwareId ) and (not exists (select s2.id from service s2 where s2.customer_id = s.customer_id and s2.service_status_id <> 1) or :hardwareStatusId <> 1 ))", nativeQuery = true)
    int setHardwareStatusByHardware_Id(@Param("hardwareId") Long hardwareId, @Param("hardwareStatusId") Long hardwareStatusId);

    @Modifying
    @Transactional
    @Query(value = "update hardware set hardware_status_id = 1 where id = :hardwareId ; update service set service_status_id = 1 where id = (select h.service_id from hardware h where h.id = :hardwareId and not exists (select h2.id from hardware h2 where h2.service_id = h.service_id and h2.hardware_status_id <> 1)) ; update customer set customer_status_id = 1 where id = (select s.customer_id from service s where s.id = (select service_id from hardware where id = :hardwareId ) and (not exists (select s2.id from service s2 where s2.customer_id = s.customer_id and s2.service_status_id <> 1)))", nativeQuery = true)
    int setHardwareStatusNormalByHardware_Id(@Param("hardwareId") Long hardwareId);
    @Modifying
    @Transactional
    @Query(value = "update hardware set hardware_status_id = 2 where id = :hardwareId ; update service set service_status_id = 2 where id = (select h.service_id from hardware h where h.id = :hardwareId ) ; update customer set customer_status_id = 2 where id = (select distinct s.customer_id from hardware h, service s where h.id = :hardwareId and s.id = h.service_id)", nativeQuery = true)
    int setHardwareStatusFailByHardware_Id(@Param("hardwareId") Long hardwareId);
    @Modifying
    @Transactional
    @Query(value = "update Hardware h set h.hardwareStatus.id = 3 where h.id = :hardwareId ; update service set service_status_id = 3 where id = (select h.service_id from hardware h where h.id = :hardwareId ) ; update customer set customer_status_id = 2 where id = (select distinct s.customer_id from hardware h, service s where h.id = :hardwareId and s.id = h.service_id)", nativeQuery = true)
    int setHardwareStatusUnderMaintByHardware_Id(@Param("hardwareId") Long hardwareId);

    @Modifying
    @Transactional
    @Query(value = "update hardware set service_id = (select old_hw.service_id from hardware old_hw where old_hw.id = :oldHardwareId ) where id = :newHardwareId ; update hardware set service_id = null where id = :oldHardwareId ; update service set service_status_id = 1 where id = (select h.service_id from hardware h where h.id = :newHardwareId and not exists (select h2.id from hardware h2 where h2.service_id = h.service_id and h2.hardware_status_id <> 1)) ; update customer set customer_status_id = 1 where id = (select s.customer_id from service s where s.id = (select service_id from hardware where id = :newHardwareId ) and (not exists (select s2.id from service s2 where s2.customer_id = s.customer_id and s2.service_status_id <> 1)))", nativeQuery = true)
    int replaceHardware(@Param("oldHardwareId") Long oldHardwareId, @Param("newHardwareId") Long newHardwareId);
}
