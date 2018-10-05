package com.gooddata.homework.sentenses;

import java.util.Date;
import java.util.UUID;

@SuppressWarnings("WeakerAccess")
public class SentenceEntity
{
    private String id;

    private Date createdDate;

    private String verb;

    private String noun;

    private String adjective;

    private Integer showsCount;

    SentenceEntity(String verb, String noun, String adjective)
    {
        this.id = UUID.randomUUID().toString();
        this.createdDate = new Date();
        this.verb = verb;
        this.noun = noun;
        this.adjective = adjective;
        this.showsCount = 0;
    }

    public String getId()
    {
        return id;
    }

    public String getSentence()
    {
        return noun + " " + verb + " " + adjective;
    }

    public String getYodaTalkSentence()
    {
        return adjective + " " + noun + " " + verb;
    }

    public void increaseShowsCount()
    {
        this.showsCount++;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public String getVerb()
    {
        return verb;
    }

    public String getNoun()
    {
        return noun;
    }

    public String getAdjective()
    {
        return adjective;
    }

    public Integer getShowsCount()
    {
        return showsCount;
    }
}
