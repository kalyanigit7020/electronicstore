package com.lcwd.electronic.store.ElectronicStore.entities;




import lombok.Getter;
import lombok.Setter;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
@Entity
public class Product {



     @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
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
