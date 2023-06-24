package com.lcwd.electronic.store.ElectronicStore.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {


    private String categoryId;

    private String title;

    private String description;

    private String coverImage;

}
