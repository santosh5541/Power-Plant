package com.virtualpowerplant.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the application.
 * This class handles exceptions thrown by the controllers and provides appropriate responses.
 *
 * @author santosh
 * @since 26 July 2024
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public String HandleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
    return resourceNotFoundException.getMessage();
  }
}
