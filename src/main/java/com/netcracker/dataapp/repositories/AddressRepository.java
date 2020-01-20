package com.netcracker.dataapp.repositories;

import com.netcracker.dataapp.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
