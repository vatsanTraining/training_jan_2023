package com.example.demo;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.example.demo.model.Student;

@SpringBootApplication
public class CloudStreamProcessorApplication {

	
	@Autowired
	StreamBridge bridge ;
	
	public static void main(String[] args) {
		SpringApplication.run(CloudStreamProcessorApplication.class, args);
		
	}

	@Bean
	 public Function<Student, Student> processStudent() {
	    
	    return element ->  { 
	if(element.getMark()>50) {
	              element.setResult("pass");
	                   Message<Student> message = MessageBuilder.withPayload(element)
	                      .setHeader(KafkaHeaders.MESSAGE_KEY, element.getId())
	                      .build();
	              bridge.send("pass-topic",message);
	              } else {
	 
	            	  element.setResult("fail");
	                   Message<Student> message = MessageBuilder.withPayload(element)
	                      .setHeader(KafkaHeaders.MESSAGE_KEY, element.getId())
	                      .build();
	              bridge.send("fail-topic",message);
	       
	            	  
	              }
	return element;
	    };
	    };
}
