package com.learningattendance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningattendance.domain.AttendanceByStudent;

@RestController
@RequestMapping("/api/v1")
public class GetAttendancesByStudentController {
  @GetMapping("/student/{studentId}/attendances")
  public ResponseEntity<AttendanceByStudent> getAttendances(@PathVariable("studentId") String id) {
    return new ResponseEntity<AttendanceByStudent>(new AttendanceByStudent(), null);
  }
}
