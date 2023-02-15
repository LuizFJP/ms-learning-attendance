package com.learningattendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningattendance.domain.Attendance;
import com.learningattendance.dto.CreatedStudentEventDTO;
import com.learningattendance.dto.RegisterRequestDTO;
import com.learningattendance.exception.CourseDoesNotMatchException;
import com.learningattendance.exception.StudentNotFoundException;

import java.util.Collection;
import java.util.UUID;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

@Service
public class RegisterStudentAttendanceService {
  @Autowired
  RedissonClient redissonClient;

  private final String ATTENDANCE_KEY = "attendance";
  private final String STUDENT_KEY = "student";

  public void studentExists(RegisterRequestDTO student) {
    CreatedStudentEventDTO studentRetrived = getStudent(student.getStudentId());
    if (studentRetrived == null) {
      throw new StudentNotFoundException();
    }
  }

  public void courseMatch(RegisterRequestDTO student) {
    CreatedStudentEventDTO studentRetrived = getStudent(student.getStudentId());
    if (studentRetrived.courseIsDifferent(student.getCourseId())) {
      throw new CourseDoesNotMatchException();
    }
  }

  public void register(RegisterRequestDTO request) {
    RMap<UUID, Attendance> attendanceHash = redissonClient.getMap(ATTENDANCE_KEY);
    var attendance = new Attendance(request);
    attendanceHash.put(attendance.getAttendanceId(), attendance);

  }

  private CreatedStudentEventDTO getStudent(UUID studentId) {
    RMap<UUID, CreatedStudentEventDTO> studentHash = redissonClient.getMap(STUDENT_KEY);

    return studentHash.get(studentId);
  }

}
