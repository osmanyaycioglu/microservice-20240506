package org.training.microservice.nodeconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableConfigServer
public class NodeConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeConfigApplication.class,
                              args);
    }

}
