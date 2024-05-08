package org.training.microservice.msorder.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.training.microservice.msorder.integration.restaurant.RestaurantReserveIntegration;

@Profile("prof1")
@Configuration
public class ServiceConfig {

    @Bean
    public IOrderManagementService orderManagementService(RestaurantReserveIntegration reserveIntegrationParam){
        return new OrderManagementService(reserveIntegrationParam);
    }

}

