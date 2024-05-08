package org.training.microservice.msrestaurant.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msrestaurant.rest.models.ReserveRequest;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;

public interface ICookManagementController {

    @PostMapping("/api/v1/cook/management/reserve")
    ReserveResponse reserve(@RequestBody ReserveRequest reserveRequest);
}
