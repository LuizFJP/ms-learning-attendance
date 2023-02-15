package com.learningattendance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GetAttendancesByStudentController {
  @GetMapping("/student/{studentId}/attendances")
  public ResponseEntity<Object> getAttendances(@PathVariable("studentId") String id) {
    
  }
}
