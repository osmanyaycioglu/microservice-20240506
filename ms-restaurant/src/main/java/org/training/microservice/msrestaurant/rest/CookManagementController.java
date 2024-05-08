package org.training.microservice.msrestaurant.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;
import org.training.microservice.msrestaurant.rest.models.ReserveRequest;
import reactor.core.publisher.Flux;

@RestController
public class CookManagementController implements ICookManagementController {

    @Value("${server.port}")
    private Integer port;

    public ReserveResponse reserve(@RequestBody ReserveRequest reserveRequest) {
        return ReserveResponse.builder()
                              .withDescParam("response from : " + port)
                              .withEstimatedTimeParam(20)
                              .build();
    }

}
