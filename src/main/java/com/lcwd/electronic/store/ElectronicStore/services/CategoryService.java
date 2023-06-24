package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.PageableResponse;
import com.lcwd.electronic.store.ElectronicStore.dtos.CategoryDto;

public interface CategoryService {

    //create
    CategoryDto create (CategoryDto categoryDto);

    //update

    CategoryDto update (CategoryDto categoryDto, Integer categoryId);


    //delete
    void delete (Integer categoryId);

    //getAll


     PageableResponse <CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);

    //getsinglecategroy


    CategoryDto get(Integer categoryId);

}
