package com.virtualpowerplant.exception;

/**
 * Exception thrown when a requested resource is not found.
 *
 * @author santosh
 * @since 26 July 2024
 */
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
