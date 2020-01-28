package com.netcracker.dataapp.entities.projections;

import com.netcracker.dataapp.entities.Customer;
import com.netcracker.dataapp.entities.Service;
import com.netcracker.dataapp.entities.ServiceStatus;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "plain", types = Service.class)
public interface ServiceProjection {
    Long getId();

    String getName();

    Customer getCustomer();

    ServiceStatus getServiceStatus();
}
