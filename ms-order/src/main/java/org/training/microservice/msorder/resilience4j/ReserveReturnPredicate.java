package org.training.microservice.msorder.resilience4j;

import org.training.microservice.msrestaurant.rest.models.ReserveResponse;

import java.util.function.Predicate;

public class ReserveReturnPredicate implements Predicate<ReserveResponse> {
    @Override
    public boolean test(final ReserveResponse reserveResponseParam) {
        if (reserveResponseParam.getDesc().contains("11000")) {
            return true;
        }
        return false;
    }
}
