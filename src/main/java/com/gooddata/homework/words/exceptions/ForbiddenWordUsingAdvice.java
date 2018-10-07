package com.gooddata.homework.words.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@SuppressWarnings("unused")
public class ForbiddenWordUsingAdvice
{
    @ResponseBody
    @ExceptionHandler(ForbiddenWordUsingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String forbiddenWordUsingHandler(ForbiddenWordUsingException ex)
    {
        return ex.getMessage();
    }
}
