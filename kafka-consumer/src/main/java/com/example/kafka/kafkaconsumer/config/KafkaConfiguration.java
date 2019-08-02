package com.example.kafka.kafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.kafka.kafkaconsumer.model.User;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		
		Map<String, Object> config = new HashMap<>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, String>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(consumerFactory());
		
		return factory;		
	}
	
	/*
	 * @Bean public ConsumerFactory<String, User> consumerFactoryJson() {
	 * 
	 * Map<String, Object> config = new HashMap<>();
	 * 
	 * config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	 * config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
	 * config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	 * StringDeserializer.class);
	 * config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	 * JsonDeserializer.class);
	 * 
	 * return new DefaultKafkaConsumerFactory<String, User>(config, new
	 * StringDeserializer(), new JsonDeserializer<>(User.class)); }
	 * 
	 * @Bean public ConcurrentKafkaListenerContainerFactory<String, User>
	 * jsonListenerContainerFactory() {
	 * ConcurrentKafkaListenerContainerFactory<String, User> factory = new
	 * ConcurrentKafkaListenerContainerFactory<>();
	 * 
	 * factory.setConsumerFactory(consumerFactoryJson());
	 * 
	 * return factory; }
	 */
	
}
