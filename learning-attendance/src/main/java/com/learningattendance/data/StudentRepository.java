package com.learningattendance.data;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.learningattendance.dto.CreatedStudentEventDTO;

import java.util.UUID;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

@Component
public class StudentRepository {
  @Autowired
  RedissonClient redissonClient;

  private final String STUDENT_KEY = "student";

  public CreatedStudentEventDTO get(UUID studentId) {
    RMap<UUID, CreatedStudentEventDTO> studentHash = redissonClient.getMap(STUDENT_KEY);

    return studentHash.get(studentId);
  }

  public void save(CreatedStudentEventDTO student) {
    RMap<UUID, CreatedStudentEventDTO> studentHash = redissonClient.getMap(STUDENT_KEY);
    studentHash.put(student.getStudentId(), student);
  }
}