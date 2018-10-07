package com.gooddata.homework.words.exceptions;

public class ForbiddenWordUsingException extends RuntimeException
{
    public ForbiddenWordUsingException(String word)
    {
        super(word + " is forbidden!");
    }
}
