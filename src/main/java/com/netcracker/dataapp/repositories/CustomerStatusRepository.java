package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.CustomerStatus;
import org.springframework.data.repository.CrudRepository;

public interface CustomerStatusRepository extends CrudRepository<CustomerStatus, Long> {
}
