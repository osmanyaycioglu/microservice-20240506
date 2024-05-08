package org.training.microservice.msorder.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prof2")
@Configuration
public class ServiceConfig2 {
    @Bean
    public IOrderManagementService orderManagementService(){
        return new OrderManagementService2();
    }
}

