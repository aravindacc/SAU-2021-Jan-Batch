package com.assignment.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageTransfer {
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	 String msg = "AfterPass";
	 
	 @KafkaListener(topics="BeforePass",groupId="beforepass")
	 void transfer(String message) {
		 kafkaTemplate.send(msg,message);
}
}
