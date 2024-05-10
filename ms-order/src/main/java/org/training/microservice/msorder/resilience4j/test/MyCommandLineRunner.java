package org.training.microservice.msorder.resilience4j.test;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyCommandLineRunner implements CommandLineRunner {
    private final MyTestBean             myTestBean;
    private final CircuitBreakerRegistry circuitBreakerRegistry;

    @Override
    public void run(final String... args) throws Exception {
        CircuitBreaker         circuitBreakerLoc = circuitBreakerRegistry.circuitBreaker("circuit-reserve");
        CircuitBreaker.Metrics metricsLoc        = circuitBreakerLoc.getMetrics();
        circuitBreakerLoc.getEventPublisher()
                         .onStateTransition(e -> System.out.println("State changed : "
                                                                    + circuitBreakerLoc.getState()
                                                                    + " Event : "
                                                                    + e));
        for (int i = 0; i < 100; i++) {

            System.out.println("Calling : " + i);
            try {
                Thread.sleep(100);
                String stringLoc = myTestBean.callMe("osman");
                System.out.println("Returned :  " + stringLoc);
            } catch (Exception eParam) {
                System.out.println("Error : " + eParam.getMessage() + " type : " + eParam.getClass());
            }
            metricsLoc        = circuitBreakerLoc.getMetrics();
            System.out.println("CB :" + circuitBreakerLoc.getState()
                               + " NumberOfSuccessfulCalls : "
                               + metricsLoc.getNumberOfSuccessfulCalls()
                               + " NumberOfFailedCalls : "
                               + metricsLoc.getNumberOfFailedCalls()
                               + " NumberOfNotPermittedCalls : "
                               + metricsLoc.getNumberOfNotPermittedCalls()
                               + " FailureRate : "
                               + metricsLoc.getFailureRate()
            );

        }
    }

}
