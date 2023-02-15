package com.learningattendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import com.learningattendance.dto.RegisterRequestDTO;

public class Attendance {
  private UUID attendanceId;
  private UUID studentId;
  private UUID courseId;
  private LocalDateTime classDate;
  private boolean attendanceStatus;

  public Attendance(){}

  public Attendance(RegisterRequestDTO request) {
    attendanceId = UUID.randomUUID();
    studentId = request.getStudentId();
    courseId = request.getCourseId();
    classDate = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    attendanceStatus = request.isAttendanceStatus();
  }

  public UUID getAttendanceId() {
    return attendanceId;
  }

  public void setAttendanceId(UUID attendanceId) {
    this.attendanceId = attendanceId;
  }

  public UUID getStudentId() {
    return studentId;
  }

  public void setStudentId(UUID studentId) {
    this.studentId = studentId;
  }

  public UUID getCourseId() {
    return courseId;
  }

  public void setCourseId(UUID courseId) {
    this.courseId = courseId;
  }

  public LocalDateTime getClassDate() {
    return classDate;
  }

  public void setClassDate(LocalDateTime classDate) {
    this.classDate = classDate;
  }

  public boolean isAttendanceStatus() {
    return attendanceStatus;
  }

  public void setAttendanceStatus(boolean attendanceStatus) {
    this.attendanceStatus = attendanceStatus;
  }

  @Override
  public String toString() {
    return "Attendance [attendanceId=" + attendanceId + ", studentId=" + studentId + ", courseId=" + courseId
        + ", classDate=" + classDate + ", attendanceStatus=" + attendanceStatus + "]";
  }
}
