package com.gooddata.homework.exceptions;

public class ForbiddenWordUsingException extends RuntimeException
{
    public ForbiddenWordUsingException(String word)
    {
        super(word + " is forbidden!");
    }
}
