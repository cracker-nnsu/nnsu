package com.netcracker.dataapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Service service;

    @NotNull
    private String serial;

    @NotNull
    @ManyToOne
    private HardwareStatus hardwareStatus;

    @ManyToOne
    private Address address;

    @Override
    public String toString() {
        return name;
    }
}
