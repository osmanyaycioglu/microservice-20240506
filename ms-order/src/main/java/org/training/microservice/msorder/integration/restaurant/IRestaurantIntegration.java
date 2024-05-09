package org.training.microservice.msorder.integration.restaurant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.microservice.msrestaurant.rest.ICookManagementController;
import org.training.microservice.msrestaurant.rest.models.ReserveRequest;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;

@FeignClient(value = "RESTAURANT",contextId = "a1")
public interface IRestaurantIntegration extends ICookManagementController {

}
