package com.netcracker.dataapp.entities.projections;

import com.netcracker.dataapp.entities.Address;
import com.netcracker.dataapp.entities.Hardware;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "plain", types = Address.class)
public interface AddressProjection {
    Long getId();

    String getFullAddress();

    List<Hardware> getHardwares();
}
