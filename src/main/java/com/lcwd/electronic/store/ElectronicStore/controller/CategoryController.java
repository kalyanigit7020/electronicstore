package com.lcwd.electronic.store.ElectronicStore.controller;

import com.lcwd.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.lcwd.electronic.store.ElectronicStore.dtos.PageableResponse;
import com.lcwd.electronic.store.ElectronicStore.payloads.ApiResponse;
import com.lcwd.electronic.store.ElectronicStore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catgoryDto) {
        CategoryDto categoryDto1 = categoryService.create(catgoryDto);

        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);

    }



    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
        CategoryDto update = categoryService.update(categoryDto, categoryId);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {

        categoryService.delete(categoryId);

        ApiResponse response = ApiResponse.builder().message("category is deleted").success("true").build();

        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<PageableResponse<CategoryDto>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {


        PageableResponse<CategoryDto> pageableResponse = categoryService.getAll(pageNumber, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(pageableResponse, HttpStatus.OK);


    }



    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingle(@PathVariable Integer categoryId){

        CategoryDto categoryDto = categoryService.get(categoryId);

        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
}





