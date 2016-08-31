package com.five;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(SpittleNotFoundException.class)
    public String SpittleHandler(){
        return "xvideos";
    }
}
