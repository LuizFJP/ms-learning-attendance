package com.learningattendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningattendance.dto.AttendanceStatusDTO;
import com.learningattendance.dto.RegisterRequestDTO;
import com.learningattendance.service.RegisterStudentAttendanceService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class RegisterStudentAttendanceController {
  @Autowired
  RegisterStudentAttendanceService registerService;

  @PostMapping("/course/{courseId}/student/{studentId}/attendance")
  public void create(
  @RequestBody AttendanceStatusDTO attendanceStatus,
  @PathVariable("courseId") UUID courseId,
  @PathVariable("studentId") UUID studentId) {
    var registerDTO = new RegisterRequestDTO(courseId, studentId, attendanceStatus);
    registerService.studentExists(registerDTO);
    registerService.courseMatch(registerDTO);
    registerService.register(registerDTO);
  }
}
