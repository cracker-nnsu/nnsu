package com.netcracker.dataapp.entities.projections;

import com.netcracker.dataapp.entities.Address;
import com.netcracker.dataapp.entities.Hardware;
import com.netcracker.dataapp.entities.HardwareStatus;
import com.netcracker.dataapp.entities.Service;
import org.springframework.data.rest.core.config.Projection;


@Projection(name = "plain", types = Hardware.class)
public interface HardwareProjection {
    Long getId();

    String getName();

    Service getService();

    String getSerial();

    HardwareStatus getHardwareStatus();

    Address getAddress();
}
