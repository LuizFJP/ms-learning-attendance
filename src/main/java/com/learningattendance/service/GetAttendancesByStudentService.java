package com.learningattendance.service;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningattendance.data.AttendanceRepository;
import com.learningattendance.data.StudentRepository;
import com.learningattendance.domain.Attendance;
import com.learningattendance.domain.AttendanceByStudent;
import com.learningattendance.util.GetStudentRequest;
import com.learningattendance.dto.AttendanceDTO;

@Service
public class GetAttendancesByStudentService {
  @Autowired
  AttendanceRepository attendanceRepository;

  @Autowired
  StudentRepository studentRepository;

  private final String ATTENDANCE_KEY = "attendance";

  public AttendanceByStudent getAttendancesByStudent(UUID studentId) {
    var student = GetStudentRequest.get(studentId);
    var filtedAttendances = getAttendances(studentId);
    return new AttendanceByStudent(
        student.getFullName(),
        student.getCourseName(),
        filtedAttendances);
  }

  public List<AttendanceDTO> getAttendances(UUID studentId) {
    var attendances = attendanceRepository.getAll();
    List<AttendanceDTO> filtedAttendances = new ArrayList<>();
    for (Attendance attendance : attendances) {
      if (attendance.getStudentId().equals(studentId)) {
        AttendanceDTO attendanceDTO = new AttendanceDTO(attendance.getClassDate(), attendance.isAttendanceStatus());
        filtedAttendances.add(attendanceDTO);
      }
    }
    return filtedAttendances;
  }
}
