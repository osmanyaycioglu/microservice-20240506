package org.training.microservice.mscommon.error;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorObj {
    private List<ErrorObj> errorObjs;
    private String desc;
    private int errorCode;

    @Builder(setterPrefix = "with")
    public ErrorObj(final List<ErrorObj> errorObjsParam,
                    final String descParam,
                    final int errorCodeParam) {
        errorObjs = errorObjsParam;
        desc      = descParam;
        errorCode = errorCodeParam;
    }
}
