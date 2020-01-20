package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.ServiceStatus;
import org.springframework.data.repository.CrudRepository;

public interface ServiceStatusRepository extends CrudRepository<ServiceStatus, Long> {
}
