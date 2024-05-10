package org.training.microservice.msorder.integration.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String dest;
    private String msg;

}
