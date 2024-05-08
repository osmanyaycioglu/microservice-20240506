package org.training.microservice.mscommon.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ErrorAdvice.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withDescParam(exp.getMessage())
                       .withErrorCodeParam(10022)
                       .build();
    }

    @ExceptionHandler(IllegalAccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj handleException(IllegalAccessException exp) {
        return ErrorObj.builder()
                       .withDescParam(exp.getMessage())
                       .withErrorCodeParam(10044)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withDescParam("validation error")
                       .withErrorCodeParam(10045)
                       .withErrorObjsParam(exp.getAllErrors()
                                              .stream()
                                              .map(ve -> ErrorObj.builder()
                                                                 .withDescParam(ve.toString())
                                                                 .withErrorCodeParam(10055)
                                                                 .build())
                                              .collect(Collectors.toList()))
                       .build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(Exception exp) {
        logger.error("[ErrorAdvice][handleException]-> *Error* : " + exp.getMessage(),
                     exp);
        if (exp instanceof NullPointerException) {
            NullPointerException nullPointerExceptionLoc = (NullPointerException) exp;
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                                 .header("deneme",
                                         "header test")
                                 .body(ErrorObj.builder()
                                               .withDescParam(exp.getMessage())
                                               .withErrorCodeParam(50000)
                                               .build());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("deneme",
                                     "header test")
                             .body(ErrorObj.builder()
                                           .withDescParam(exp.getMessage())
                                           .withErrorCodeParam(50000)
                                           .build());
    }

}
