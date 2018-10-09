package com.gooddata.homework.exceptions;

import com.gooddata.homework.models.WordCategory;

public class WordNotFoundException extends RuntimeException
{
    public WordNotFoundException(WordCategory wordCategory)
    {
        super("Could not find word with category - " + wordCategory.getCategory());
    }
}
