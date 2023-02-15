package com.learningattendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningattendance.domain.Attendance;
import com.learningattendance.dto.CreatedStudentEventDTO;
import com.learningattendance.dto.RegisterRequestDTO;
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

  public void studentExists(CreatedStudentEventDTO student) {
    CreatedStudentEventDTO studentRetrived = getStudent(student.getStudentId());
    if (studentRetrived == null) {
      throw new StudentNotFoundException();
    }
  }

  public void courseMatch(CreatedStudentEventDTO student) {
    CreatedStudentEventDTO studentRetrived = getStudent(student.getStudentId());
    if (studentRetrived.courseIsDifferent(student.getCourseId())) {
      throw new StudentNotFoundException();
    }
  }

  public void register(RegisterRequestDTO request) {
    // RMap<UUID, CreatedStudentEventDTO> studentHash =
    // redissonClient.getMap("student");
    // var student = new
    // CreatedStudentEventDTO(UUID.fromString("e19fc3b0-a710-4529-9256-426486cfaf04"),
    // "Luiz Portela", UUID.fromString("b54efb55-4909-42d5-96ad-4fe657097db7"));
    // studentHash.put(student.getStudentId(), student);
    RMap<UUID, Attendance> attendanceHash = redissonClient.getMap(ATTENDANCE_KEY);
    var attendance = new Attendance(request);
    attendanceHash.put(attendance.getAttendanceId(), attendance);

    redissonClient.shutdown();
  }

  private CreatedStudentEventDTO getStudent(UUID studentId) {
    RMap<UUID, CreatedStudentEventDTO> studentHash = redissonClient.getMap("student");
    return studentHash.get(studentId);
  }

}
