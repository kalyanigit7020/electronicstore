package com.lcwd.electronic.store.ElectronicStore.helper;

import com.lcwd.electronic.store.ElectronicStore.dtos.PageableResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static <U,V> PageableResponse<V> getPageableResponse(Page<U> page , Class <V> type){

        List<U> entity = page.getContent();

        List<V> dtos = entity.stream().map(object -> new ModelMapper().map(object, type)).collect(Collectors.toList());

         PageableResponse<V> response=new PageableResponse<>();
         response.setContent(dtos);
         response.setPageNumber(page.getNumber());
         response.setPageSize(page.getSize());
         response.setTotalPage(page.getTotalPages());
         response.setLastPage(page.isLast());
         response.setTotalElements(page.getTotalElements());

         return response;
    }


}
