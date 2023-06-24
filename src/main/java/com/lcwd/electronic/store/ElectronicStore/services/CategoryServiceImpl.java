package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.lcwd.electronic.store.ElectronicStore.dtos.PageableResponse;
import com.lcwd.electronic.store.ElectronicStore.entities.Category;
import com.lcwd.electronic.store.ElectronicStore.exception.ResourceNotFoundException;
import com.lcwd.electronic.store.ElectronicStore.helper.Helper;
import com.lcwd.electronic.store.ElectronicStore.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        Category save = categoryRepository.save(category);
        return mapper.map(save, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Integer categoryId) {


      Category category=  categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category not found...!!!"));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        category.setCoverImage(categoryDto.getCoverImage());
        Category save = categoryRepository.save(category);

        return mapper.map(save, CategoryDto.class);
    }

    @Override
    public void delete(Integer categoryId) {

        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("resource not found..!"));

                categoryRepository.delete(category);

    }

    @Override
    public PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Pageable pageable= PageRequest.of(pageNumber,pageSize);

        Page<Category> page = categoryRepository.findAll(pageable);

        PageableResponse<CategoryDto> pageableResponse = Helper.getPageableResponse(page, CategoryDto.class);

        return pageableResponse;
    }

    @Override
    public CategoryDto get(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("resource not found..!"));

        return mapper.map(category, CategoryDto.class);
    }
}
