package com.example.demo;

import org.apache.http.HttpResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.AbstractServerHttpResponse;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Log4j2
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public GlobalFilter postFilter() {
		
		
		
		   return (exchange, chain) -> {
	            return chain.filter(exchange)
	              .then(Mono.fromRunnable(() -> {
	                  log.info("Global Post Filter executed");
	                  exchange.getResponse().getHeaders().add("author", "bfl-byte");
	                  AbstractServerHttpResponse  resp = (AbstractServerHttpResponse)exchange.getResponse();
	                  log.info(resp.getNativeResponse().toString());
	                  exchange.getResponse().setRawStatusCode(209);
	              }));
	      
	      };
	}
}
