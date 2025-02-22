package org.woolf.UserService.advices;

import org.woolf.UserService.dtos.ExceptionDto;
import org.woolf.UserService.exceptions.DuplicateRecordsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){
        ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        //ex.printStackTrace();
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateRecordsException.class)
    ResponseEntity<ExceptionDto> handleDuplicateRecordsException(DuplicateRecordsException ex){
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<ExceptionDto> handleBadCredentialsException(BadCredentialsException ex){
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.UNAUTHORIZED, ex.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<ExceptionDto> handleUserNameNotFoundException(UsernameNotFoundException ex){
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
