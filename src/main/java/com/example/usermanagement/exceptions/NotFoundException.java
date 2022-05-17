package com.example.usermanagement.exceptions;

/**
 * Exception thrown when requesting an entity that doesn't exist.
 */
public class NotFoundException extends Exception {

  public NotFoundException(String message) {
    super(message);
  }

  /**
   * We don't need to print out stack traces for NotFoundException.
   */
  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
