package com.learningattendance.util;

import java.util.UUID;

import org.springframework.web.client.RestTemplate;
import com.learningattendance.dto.StudentResponseDTO;
import com.learningattendance.exception.StudentNotFoundException;


public abstract class GetStudentRequest {
  public static StudentResponseDTO get(UUID studentId) {
    String uri = "http://localhost:8082/api/v1/student/" + studentId;
    RestTemplate restTemplate = new RestTemplate();
    StudentResponseDTO student = restTemplate.getForObject(uri, StudentResponseDTO.class);
    if (student == null)
      throw new StudentNotFoundException();

      return student;
  }
}
