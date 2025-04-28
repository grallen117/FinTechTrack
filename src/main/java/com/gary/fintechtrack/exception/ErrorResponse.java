package com.gary.fintechtrack.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private int status;
    private LocalDateTime timestamp;


}
