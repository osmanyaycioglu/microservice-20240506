package org.training.microservice.mscommon.error;


import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CommonErrorDecoder implements ErrorDecoder {
    @Override
    public MyFeignResponseException decode(final String sParam,
                            final Response responseParam) {
        ObjectMapper objectMapperLoc = new ObjectMapper();
        try {
            ErrorObj errorObjLoc = objectMapperLoc.readValue(responseParam.body().asInputStream(),
                                                             ErrorObj.class);
            return new MyFeignResponseException(errorObjLoc);
        } catch (Exception exParam) {
            throw new MyFeignResponseException();
        }

    }
}
