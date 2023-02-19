package com.learningattendance.exception;

public class CourseDoesNotMatchException extends RuntimeException {
  public CourseDoesNotMatchException() {
    super("Course does not registred for student.");
  }
}
