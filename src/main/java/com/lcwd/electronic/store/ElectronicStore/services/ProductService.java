package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.ProductDto;
import com.lcwd.electronic.store.ElectronicStore.dtos.UserDto;

import java.util.List;

public interface ProductService {


   ProductDto createProduct(ProductDto productDto);

   ProductDto updateProduct(ProductDto productDto, Integer productId);

   void deleteProduct (Integer productId);

   List<ProductDto> getAllProduct();

   ProductDto getProduct(Integer ProductId);

   List<ProductDto>searchProduct(String keyword);

}
