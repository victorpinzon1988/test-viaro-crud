package com.viaro.test.viarobackendcrud.model.pojo;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ErrorResponseViaro {

    private HttpStatus httpStatus;
    private Integer errorCode;
    private LocalDateTime timestamp;
    private String message;

}
