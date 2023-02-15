package com.learningattendance.domain;

import java.util.List;

import com.learningattendance.dto.AttendanceDTO;

public class AttendanceByStudent {
  private String fullName;
  private String courseName;
  private List<AttendanceDTO> attendances;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public List<AttendanceDTO> getAttendances() {
    return attendances;
  }

  public void setAttendances(List<AttendanceDTO> attendances) {
    this.attendances = attendances;
  }

}
