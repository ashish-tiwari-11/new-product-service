package com.aws.prac.ecs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tblProducts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "productName", unique = true, nullable = false)
    private String productName;

    @Column(name = "productDescription",nullable = false,updatable = true)
    private String productDescription;

    @Column(name = "productQuantity",nullable = false,updatable = true)
    private int productQuantity;

    @Column(name = "productPrice",nullable = false,updatable = true)
    private int productPrice;

    @Column(name = "productInsertionTS", nullable = true, unique = true)
    private LocalDate productInsertionTS;
}
