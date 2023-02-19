package com.learningattendance.data;

import org.springframework.stereotype.Component;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.learningattendance.domain.Attendance;
import com.learningattendance.dto.RegisterRequestDTO;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

import org.redisson.api.RMap;

@Component
public class AttendanceRepository {
  @Autowired
  RedissonClient redissonClient;

  private final String ATTENDANCE_KEY = "attendance";

  public void save(RegisterRequestDTO attendanceEntity) {
    RMap<UUID, Attendance> attendanceHash = redissonClient.getMap(ATTENDANCE_KEY);
    var attendance = new Attendance(attendanceEntity);
    attendanceHash.put(attendance.getAttendanceId(), attendance);
  }

  public List<Attendance> getAll() {
    RMap<UUID, Attendance> attendanceHash = redissonClient.getMap(ATTENDANCE_KEY);
    return new ArrayList<Attendance>(attendanceHash.readAllValues());
  }
}
