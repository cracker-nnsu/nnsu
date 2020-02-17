package com.netcracker.dataapp.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(unique=true)
    private String phoneNumber;

    @NotNull
    @ManyToOne
    private CustomerStatus customerStatus;

    @NotNull
    @OneToMany(mappedBy = "customer")
    private List<Service> services;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
