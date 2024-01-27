package com.consubanco.postgres.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.OffsetDateTime;

@Entity
@Table(name = "spend", schema = "pruebatecnica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpendDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    private BigInteger phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "curp", nullable = false)
    private String curp;
    @Column(name = "rfc", nullable = false)
    private String rfc;
    @Column(name = "name_task", nullable = false)
    private String nameTask;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "initial_date", nullable = false)
    private OffsetDateTime initialDate;
    @Column(name = "end_date", nullable = false)
    private OffsetDateTime endDate;
    @Column(name = "state", nullable = false)
    private Boolean state;
}
