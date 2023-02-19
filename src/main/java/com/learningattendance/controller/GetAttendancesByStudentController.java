package com.learningattendance.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningattendance.domain.AttendanceByStudent;
import com.learningattendance.service.GetAttendancesByStudentService;

@RestController
@RequestMapping("/api/v1")
public class GetAttendancesByStudentController {
  @Autowired
  GetAttendancesByStudentService getAttendancesService;
  @GetMapping("/student/{studentId}/attendances")
  public ResponseEntity<AttendanceByStudent> getAttendances(@PathVariable("studentId") UUID id) {
    return new ResponseEntity<AttendanceByStudent>(getAttendancesService.getAttendancesByStudent(id), HttpStatus.OK);
  }
}
