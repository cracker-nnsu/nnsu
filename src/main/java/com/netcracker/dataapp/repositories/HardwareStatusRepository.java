package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.HardwareStatus;
import org.springframework.data.repository.CrudRepository;

public interface HardwareStatusRepository extends CrudRepository<HardwareStatus, Long> {
}
