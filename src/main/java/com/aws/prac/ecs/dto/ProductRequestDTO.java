package com.aws.prac.ecs.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productPrice;
}
