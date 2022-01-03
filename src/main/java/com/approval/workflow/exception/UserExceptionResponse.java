package com.approval.workflow.exception;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;


public class UserExceptionResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timeStamp;
    private String errorMessage;
    private String details;

    public UserExceptionResponse(){

    }
    public UserExceptionResponse(LocalDateTime timeStamp, String errorMessage, String details) {
        this.timeStamp = timeStamp;
        this.errorMessage = errorMessage;
        this.details = details;
    }
}

