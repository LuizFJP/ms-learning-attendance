package com.learningattendance.dto;

import java.util.UUID;
import java.io.Serializable;

public class CreatedStudentEventDTO implements Serializable{
  private UUID studentId;
  private String fullName;
  private UUID courseId;

  public CreatedStudentEventDTO(){}

  public CreatedStudentEventDTO(UUID _studentId, String _fullName, UUID _courseId) {
    studentId = _studentId;
    fullName = _fullName;
    courseId = _courseId;
  }
  
  public UUID getStudentId() {
    return studentId;
  }

  public void setStudentId(UUID studentId) {
    this.studentId = studentId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public UUID getCourseId() {
    return courseId;
  }

  public void setCourseId(UUID courseId) {
    this.courseId = courseId;
  }

  public boolean courseIsDifferent(UUID _courseId) {
    return !courseId.equals(_courseId);
  }

}
