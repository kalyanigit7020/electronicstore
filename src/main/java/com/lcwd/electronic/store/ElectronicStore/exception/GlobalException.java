package com.lcwd.electronic.store.ElectronicStore.exception;

import com.lcwd.electronic.store.ElectronicStore.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalException extends RuntimeException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException e) {

        ApiResponse response = ApiResponse.builder().message(e.getMessage()).success("true").build();
       return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }


    public ResponseEntity<ApiResponse> HandleBadRequest(ResourceNotFoundException e){

        ApiResponse response = ApiResponse.builder().message(e.getMessage()).success("false").build();

        return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
    }

}