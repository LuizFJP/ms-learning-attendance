package com.learningattendance.dto;

import java.time.LocalDateTime;

public class AttendanceDTO {
  private LocalDateTime classDate;
  private boolean attendanceStatus;

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

  public AttendanceDTO(LocalDateTime _classDate, boolean _attendanceStatus) {
    classDate = _classDate;
    attendanceStatus = _attendanceStatus;
  }

}
