package com.example.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.context.ShutdownEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomInfoEndPoint implements InfoContributor {

	ShutdownEndpointAutoConfiguration con;
	
	@Autowired
	ConfigurableApplicationContext ctx;
	
	@Override
	public void contribute(Builder builder) {

		Map<String,Object> details = new HashMap<>();
		
		  details.put("totalBeans",  ctx.getBeanDefinitionCount())  ;
		  details.put("startDate", ctx.getStartupDate());
		  
		  builder.withDetails(details);
	}

}
