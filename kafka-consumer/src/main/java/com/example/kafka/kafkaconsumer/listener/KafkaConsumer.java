package com.example.kafka.kafkaconsumer.listener;

import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.kafkaconsumer.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumer {
	
	private User user;
	private ObjectMapper mapper = new ObjectMapper();
	
	@KafkaListener(topics = "Kafka_Example", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed: " + message);
	}
	
	@KafkaListener(topics = "Kafka_Example_Json", groupId = "group_json")
	public void consumeJson(String json) throws Exception {
		user = mapper.readValue(json, User.class);
		System.out.println("Consumed JSON: " + user);
	}
	
}
