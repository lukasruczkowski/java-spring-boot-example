package com.example.usermanagement.utils;

public class Preconditions {
  public static <T> T checkNotNull(T value) {
    return checkNotNull(value, null);
  }

  public static <T> T checkNotNull(T value, String message) {
    if (value == null) {
      throw new NullPointerException(message);
    }
    return value;
  }
}
