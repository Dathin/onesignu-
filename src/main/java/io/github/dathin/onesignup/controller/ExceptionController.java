package io.github.dathin.onesignup.controller;

import io.github.dathin.onesignup.model.exception.FormResponse;
import io.github.dathin.onesignup.model.exception.GenericException;
import io.github.dathin.onesignup.model.exception.GenericResponse;
import io.github.dathin.onesignup.model.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionController {

//    private static final Logger LOGGER = LogManager.getLogger();

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericResponse> genericResponseHandler(GenericException ex) {
        logInfo(ex);
        return ResponseEntity.status(ex.getStatus()).body(new GenericResponse(ex.getError()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> exceptionHandler(Exception ex) {
        logInfo(ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse(
                "Unexpected Error"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FormResponse>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logInfo(ex);
        List<FormResponse> formularioExceptionList = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            formularioExceptionList.add(new FormResponse(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formularioExceptionList);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List<FormResponse>> validationException(ValidationException ex) {
        logInfo(ex);
        return ResponseEntity.status(ex.getStatus()).body(ex.getFormResponse());
    }

    private void logInfo(Exception ex) {
        System.out.println(ex.getClass());
        System.out.println(ex.getLocalizedMessage());
        ex.printStackTrace();
    }

}
