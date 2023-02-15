package com.learningattendance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learningattendance.exception.CourseDoesNotMatchException;
import com.learningattendance.exception.StudentNotFoundException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CourseDoesNotMatchException.class)
  public ResponseEntity<Object> handlecourseAlreadyExistsException(
    CourseDoesNotMatchException ex, WebRequest request) {

      Map<String, Object> body = new HashMap<>();
      body.put("message", ex.getMessage());

      return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

   @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<Object> handlecourseAlreadyExistsException(
    StudentNotFoundException ex, WebRequest request) {

      Map<String, Object> body = new HashMap<>();
      body.put("message", ex.getMessage());

      return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
