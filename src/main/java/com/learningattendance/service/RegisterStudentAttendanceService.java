package com.learningattendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningattendance.data.AttendanceRepository;
import com.learningattendance.data.StudentRepository;
import com.learningattendance.dto.CreatedStudentEventDTO;
import com.learningattendance.dto.RegisterRequestDTO;
import com.learningattendance.exception.CourseDoesNotMatchException;
import com.learningattendance.exception.StudentNotFoundException;

@Service
public class RegisterStudentAttendanceService {
  @Autowired
  AttendanceRepository attendanceRepository;
  @Autowired
  StudentRepository studentRepository;

  public void studentExists(RegisterRequestDTO student) {
    CreatedStudentEventDTO studentRetrived = studentRepository.get(student.getStudentId());
    if (studentRetrived == null) {
      throw new StudentNotFoundException();
    }
  }

  public void courseMatch(RegisterRequestDTO student) {
    CreatedStudentEventDTO studentRetrived = studentRepository.get(student.getStudentId());
    if (studentRetrived.courseIsDifferent(student.getCourseId())) {
      throw new CourseDoesNotMatchException();
    }
  }

  public void register(RegisterRequestDTO request) {
    attendanceRepository.save(request);
  }
}
