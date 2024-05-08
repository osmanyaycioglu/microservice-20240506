package org.training.microservice.mscommon.error;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyFeignResponseException extends RuntimeException{
    private ErrorObj errorObj;

    public MyFeignResponseException(final ErrorObj errorObjParam) {
        errorObj = errorObjParam;
    }


}
