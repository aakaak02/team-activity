package com.aak.teamactivity.web;

import com.aak.teamactivity.domain.Activity;
import com.aak.teamactivity.dto.ErrorResponse;
import com.aak.teamactivity.exception.ActivityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
        @ExceptionHandler({ActivityNotFoundException.class})
        public ResponseEntity<ErrorResponse> activityNotFoundException(ActivityNotFoundException ex){
              ErrorResponse errorResponse = ErrorResponse.builder()
                  .errorCode(ex.getErrorCode())
                  .message(ex.getMessage())
                  .build();
              return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
}
