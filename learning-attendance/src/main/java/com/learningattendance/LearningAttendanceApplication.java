package com.learningattendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class LearningAttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningAttendanceApplication.class, args);
	}

}
