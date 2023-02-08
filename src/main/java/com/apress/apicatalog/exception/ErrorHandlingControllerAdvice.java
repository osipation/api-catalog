package com.apress.apicatalog.exception;

import com.apress.apicatalog.dto.ValidationErrorDTO;
import com.apress.apicatalog.dto.ViolationDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorDTO onConstraintValidationException(ConstraintViolationException e) {
        ValidationErrorDTO error = new ValidationErrorDTO();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            ViolationDTO violationDTO = new ViolationDTO(violation.getPropertyPath().toString(), violation.getMessage());
            error.getViolations().add(violationDTO);
        }
        return error;
    }
}
