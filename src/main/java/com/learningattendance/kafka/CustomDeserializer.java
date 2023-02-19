package com.learningattendance.kafka;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;

import com.learningattendance.dto.CreatedStudentEventDTO;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomDeserializer implements Deserializer<CreatedStudentEventDTO> {
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
  }

  @Override
  public CreatedStudentEventDTO deserialize(String topic, byte[] data) {
    try {
      if (data == null) {
        return null;
      }
      return objectMapper.readValue(new String(data, "UTF-8"), CreatedStudentEventDTO.class);
    } catch (Exception e) {
      throw new SerializationException("Error when deserializing byte[] to MessageDto");
    }
  }

  @Override
  public void close() {
  }
}