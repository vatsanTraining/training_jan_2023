package com.example.demo;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Student;

@SpringBootApplication
public class CloudStreamConsumerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CloudStreamConsumerApplication.class, args);
	}

	@Bean
	public Consumer<KStream<String, Student>> consumer(){
	 
	return stream ->  stream.foreach(
	(key,element)->{
	    System.out.println(element);
	
	});
	   }

}
