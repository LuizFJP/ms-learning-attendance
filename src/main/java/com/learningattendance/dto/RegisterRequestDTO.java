package com.learningattendance.dto;

import java.util.UUID;

public class RegisterRequestDTO {
  private UUID courseId;
  private UUID studentId;
  private boolean attendanceStatus;

  public RegisterRequestDTO(){}

  public RegisterRequestDTO(UUID _courseId, UUID _studentId, AttendanceStatusDTO _attendanceStatus){
    courseId = _courseId;
    studentId = _studentId;
    attendanceStatus = _attendanceStatus.isAttendanceStatus(); 
  }

  public UUID getCourseId() {
    return courseId;
  }

  public void setCourseId(UUID courseId) {
    this.courseId = courseId;
  }

  public UUID getStudentId() {
    return studentId;
  }

  public void setStudentId(UUID studentId) {
    this.studentId = studentId;
  }

  public boolean isAttendanceStatus() {
    return attendanceStatus;
  }

  public void setAttendanceStatus(boolean attendanceStatus) {
    this.attendanceStatus = attendanceStatus;
  }
}
