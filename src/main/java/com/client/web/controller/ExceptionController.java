package com.client.web.controller;

import com.client.web.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse notFound(EntityNotFoundException exception) {
        logger.error("Entity Not Found exception:" + exception.getMessage());
        return new ErrorResponse("EntityNotFound", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataAccessException.class)
    public ErrorResponse dataAccess(DataAccessException exception) {
        logger.error("DataAccessException exception: " + exception.getMessage());
        return new ErrorResponse("DataAccess", exception.getMessage());
    }

}