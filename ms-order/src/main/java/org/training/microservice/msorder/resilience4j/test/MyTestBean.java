package org.training.microservice.msorder.resilience4j.test;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

@Component
public class MyTestBean {

    private int counter = 0;

    @CircuitBreaker(name = "circuit-reserve",fallbackMethod = "callMe")
    public String callMe(String str) {
        counter++;
        if (counter < 15 && counter % 3 == 0) {
            throw new IllegalStateException("request " + counter);
        }
        return "hello " + counter;
    }

    public String callMe(String str,Throwable throwableParam) {
        System.out.println("Fallback Called : " + counter);
        return "fallback deneme";
    }

}
