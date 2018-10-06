package com.gooddata.homework.words.exceptions;

import com.gooddata.homework.words.WordCategory;

public class WordNotFoundException extends RuntimeException
{
    public WordNotFoundException(WordCategory wordCategory)
    {
        super("Could not find word with category - " + wordCategory.getCategory());
    }
}
