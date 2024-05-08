package org.training.microservice.msorder.integration.restaurant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.training.microservice.mscommon.error.ErrorObj;
import org.training.microservice.msorder.rest.models.Order;
import org.training.microservice.msrestaurant.rest.models.Meal;
import org.training.microservice.msrestaurant.rest.models.ReserveRequest;
import org.training.microservice.msrestaurant.rest.models.ReserveResponse;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantReserveIntegration {
    private final RestTemplate           restTemplate;
    private final EurekaClient           eurekaClient;
    private final IRestaurantIntegration restaurantIntegration;

    private AtomicLong counter = new AtomicLong();
//    private List<String> strings = Collections.synchronizedList(new ArrayList<>());
//    private Map<String,String> stringStringMap = new ConcurrentHashMap<>();


    public ReserveResponse reserve(Order orderParam) {

        ReserveRequest reserveRequestLoc = ReserveRequest.builder()
                                                         .withCustomerIdParam("asdgfdsf")
                                                         .withDueTimeParam(30)
                                                         .withMealsParam(orderParam.getMeals()
                                                                                   .stream()
                                                                                   .map(m -> Meal.builder()
                                                                                                 .withMealParam(m.getMealName())
                                                                                                 .withAmountParam(m.getAmount())
                                                                                                 .build())
                                                                                   .collect(Collectors.toList()))
                                                         .build();
        try {
            return restTemplate.postForObject("http://RESTAURANT/api/v1/cook/management/reserve",
                                              reserveRequestLoc,
                                              ReserveResponse.class);
        } catch (RestClientResponseException eParam) {
            HttpStatusCode statusCodeLoc = eParam.getStatusCode();

            ObjectMapper objectMapperLoc = new ObjectMapper();
            try {
                ErrorObj errorObjLoc = objectMapperLoc.readValue(eParam.getResponseBodyAsByteArray(),
                                                                 ErrorObj.class);
                switch (errorObjLoc.getErrorCode()) {
                    case 10044:

                }
            } catch (Exception exParam) {
                throw new IllegalStateException(exParam);
            }

        }
        return null;
    }



    public ReserveResponse reserve2(Order orderParam) {
        long lLoc = counter.incrementAndGet();

        Application        restaurantLoc   = eurekaClient.getApplication("RESTAURANT");
        List<InstanceInfo> instancesLoc    = restaurantLoc.getInstances();
        int                index           = (int) (lLoc % instancesLoc.size());
        InstanceInfo       instanceInfoLoc = instancesLoc.get(index);
        RestTemplate       restTemplateLoc = new RestTemplate();

        ReserveRequest reserveRequestLoc = ReserveRequest.builder()
                                                         .withCustomerIdParam("asdgfdsf")
                                                         .withDueTimeParam(30)
                                                         .withMealsParam(orderParam.getMeals()
                                                                                   .stream()
                                                                                   .map(m -> Meal.builder()
                                                                                                 .withMealParam(m.getMealName())
                                                                                                 .withAmountParam(m.getAmount())
                                                                                                 .build())
                                                                                   .collect(Collectors.toList()))
                                                         .build();
        ReserveResponse reserveResponseLoc = null;

        try {
            reserveResponseLoc = restTemplateLoc.postForObject("http://"
                                                               + instanceInfoLoc.getIPAddr()
                                                               + ":"
                                                               + instanceInfoLoc.getPort()
                                                               + "/api/v1/cook/management/reserve",
                                                               reserveRequestLoc,
                                                               ReserveResponse.class);
        } catch (RestClientResponseException eParam) {
            HttpStatusCode statusCodeLoc = eParam.getStatusCode();

            ObjectMapper objectMapperLoc = new ObjectMapper();
            try {
                ErrorObj errorObjLoc = objectMapperLoc.readValue(eParam.getResponseBodyAsByteArray(),
                                                                 ErrorObj.class);
                switch (errorObjLoc.getErrorCode()) {
                    case 10044:

                }
            } catch (Exception exParam) {
                throw new IllegalStateException(exParam);
            }

        }


        return reserveResponseLoc;
    }


    public ReserveResponse reserve3(Order orderParam) {

        ReserveRequest reserveRequestLoc = ReserveRequest.builder()
                                                         .withCustomerIdParam("asdgfdsf")
                                                         .withDueTimeParam(30)
                                                         .withMealsParam(orderParam.getMeals()
                                                                                   .stream()
                                                                                   .map(m -> Meal.builder()
                                                                                                 .withMealParam(m.getMealName())
                                                                                                 .withAmountParam(m.getAmount())
                                                                                                 .build())
                                                                                   .collect(Collectors.toList()))
                                                         .build();
        return restaurantIntegration.reserve(reserveRequestLoc);
    }

}
