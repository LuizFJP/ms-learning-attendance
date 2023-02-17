package com.learningattendance.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.learningattendance.data.StudentRepository;
import com.learningattendance.dto.CreatedStudentEventDTO;
import com.learningattendance.interfaces.IEventService;
import org.springframework.kafka.annotation.KafkaListener;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
  @Value("${topic.student.created}")
  private String topicName;

  @Autowired
  StudentRepository studentRepository;

  @Override
  @KafkaListener(topics = "${topic.student.created}")
  public void consume(ConsumerRecord<String, CreatedStudentEventDTO> records) {
    studentRepository.save(records.value());
  }
}