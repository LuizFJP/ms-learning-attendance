package com.learningattendance.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterStudentAttendanceController {
  @PostMapping("/course/{courseId}/student/{studentId}/attendance")
  public void create(
  @RequestBody boolean attendanceStatus,
  @PathVariable("courseId") String courseId,
  @PathVariable("studentId") String studentId) {
    
  }
}
