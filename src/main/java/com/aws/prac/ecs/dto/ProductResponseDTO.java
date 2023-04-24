package com.aws.prac.ecs.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private String productDescription;
    private int productQuantity;
    private double productPrice;
    private LocalDate productInsertionTS;
}
