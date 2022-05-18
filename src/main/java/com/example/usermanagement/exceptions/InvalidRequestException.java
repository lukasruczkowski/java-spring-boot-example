package com.example.usermanagement.exceptions;

/**
 * Exception thrown when the body of a request has missing or invalid data.
 */
public class InvalidRequestException extends Exception {

  public InvalidRequestException(String message) {
    super(message);
  }

  public InvalidRequestException(String message, Exception ex) {
    super(message, ex);
  }
}
