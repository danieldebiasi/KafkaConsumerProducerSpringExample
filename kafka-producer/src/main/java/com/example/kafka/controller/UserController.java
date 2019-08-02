package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.model.User;

@RestController
@RequestMapping("/kafka")
public class UserController {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "Kafka_Example_Json";
	
//	@PostMapping("/publish/{message}")
//	public String message(@PathVariable("message") String message) {
//		kafkaTemplate.send(topic, message);
//		
//		return "Message published";
//	}
	
	@PostMapping("/publish")
	public String post(@RequestBody User user) {		
		System.out.println(user);
		kafkaTemplate.send(TOPIC, user);
		
		return "User published";
	}
	
}
