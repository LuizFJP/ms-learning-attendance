package com.learningattendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningattendance.domain.Attendance;
import com.learningattendance.dto.RegisterRequestDTO;

import java.util.Collection;
import java.util.UUID;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

@Service
public class RegisterStudentAttendanceService {
  @Autowired
  RedissonClient redissonClient;

  private final String KEY = "attendance";
  
  public void register(RegisterRequestDTO request) {
    RMap<UUID, Attendance> studentHash = redissonClient.getMap(KEY);
    var attendance = new Attendance(request);
    studentHash.put(attendance.getAttendanceId(), attendance);

    redissonClient.shutdown();
  }
  
}
