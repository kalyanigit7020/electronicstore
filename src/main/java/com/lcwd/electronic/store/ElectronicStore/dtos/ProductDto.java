package com.lcwd.electronic.store.ElectronicStore.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Integer productId;

    private String title;

    private String description;

    private Double price;

    private Double discountedPrice;

    private Integer quantity;

    private Date addedDate;

    private boolean live;

    private String productImageName;



}
