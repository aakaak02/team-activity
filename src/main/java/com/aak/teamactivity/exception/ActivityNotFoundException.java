package com.aak.teamactivity.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityNotFoundException extends  RuntimeException{
    private String errorCode;
    public ActivityNotFoundException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
