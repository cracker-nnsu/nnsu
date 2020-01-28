package com.netcracker.dataapp.entities.projections;

import com.netcracker.dataapp.entities.Customer;
import com.netcracker.dataapp.entities.CustomerStatus;
import com.netcracker.dataapp.entities.Service;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;


@Projection(name = "plain", types = Customer.class)
public interface CustomerProjection {
    Long getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    CustomerStatus getCustomerStatus();

    List<Service> getServices();
}
