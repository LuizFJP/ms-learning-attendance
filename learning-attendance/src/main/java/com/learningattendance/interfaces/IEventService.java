package com.learningattendance.interfaces;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import com.learningattendance.dto.CreatedStudentEventDTO;

@Component
public interface IEventService {
  public void consume(ConsumerRecord<String, CreatedStudentEventDTO> records);
}
