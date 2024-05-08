package org.training.microservice.msrestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.training.microservice.mscommon.error.ErrorConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(ErrorConfig.class)
public class MsRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRestaurantApplication.class,
                              args);
    }

}
