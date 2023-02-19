package com.learningattendance.dto;

import java.time.LocalDate;

public class StudentResponseDTO {
  private String fullName;
  private String document;
  private LocalDate birthdate;
  private String courseName;
  private boolean status;
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public String getDocument() {
    return document;
  }
  public void setDocument(String document) {
    this.document = document;
  }
  public LocalDate getBirthdate() {
    return birthdate;
  }
  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }
  public String getCourseName() {
    return courseName;
  }
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  public boolean isStatus() {
    return status;
  }
  public void setStatus(boolean status) {
    this.status = status;
  }

  
}
