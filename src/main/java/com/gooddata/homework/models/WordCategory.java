package com.gooddata.homework.models;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum WordCategory implements Serializable
{
    NOUN("NOUN"),
    VERB("VERB"),
    ADJECTIVE("ADJECTIVE");

    private String category;

    WordCategory(String category)
    {
        this.category = category;
    }

    @JsonValue
    public String getCategory()
    {
        return category;
    }
}
