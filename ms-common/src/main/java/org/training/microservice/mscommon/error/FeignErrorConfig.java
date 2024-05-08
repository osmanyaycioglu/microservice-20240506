package org.training.microservice.mscommon.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignErrorConfig {

    @Bean
    public CommonErrorDecoder commonErrorDecoder(){
        return new CommonErrorDecoder();
    }

}
