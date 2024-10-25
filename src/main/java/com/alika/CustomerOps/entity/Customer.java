package com.alika.CustomerOps.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
    @SequenceGenerator(name="customer_id_generator", sequenceName = "customer_id_seq", initialValue=1 , allocationSize = 1)
    private Long id;
    @Column
    private LocalDateTime dateOfBirth;
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column
    private String createdBy;
    @Column
    private LocalDateTime createdDate;
    @Column
    private String updatedBy;
    @Column
    private LocalDateTime updatedDate;

}
