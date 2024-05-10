package org.training.microservice.apigw.order.filters;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class Logging extends AbstractGatewayFilterFactory<Logging.LogConfig> {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public Logging() {
        super(LogConfig.class);
    }

    @Override
    public GatewayFilter apply(final LogConfig config) {
        return ((exchange, chain) -> {
            if (logger.isInfoEnabled() && config.isPreLog()) {
                logger.info("[Logging][apply]-> " + config.getMessage() + "PreLog : " + exchange.getRequest());
            }
            return chain.filter(exchange)
                        .then(Mono.fromRunnable(() -> {
                                  if (logger.isInfoEnabled()) {
                                      logger.info("[Logging][apply]-> "
                                                  + config.getMessage()
                                                  + " PostLog : "
                                                  + exchange.getRequest());
                                  }
                              })
                        );
        });
    }

    @Data
    @Valid
    public static class LogConfig {
        @NotBlank
        private String  message;
        private boolean preLog;
        private boolean postLog;
    }

}
