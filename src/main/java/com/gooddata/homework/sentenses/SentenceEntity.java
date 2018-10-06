package com.gooddata.homework.sentenses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@SuppressWarnings("WeakerAccess")
public class SentenceEntity
{
    @Id
    @GeneratedValue
    private long id;

    private Date createdDate;

    private String verb;

    private String noun;

    private String adjective;

    private Integer showsCount;

    public SentenceEntity()
    {
        this.createdDate = new Date();
    }

    SentenceEntity(String verb, String noun, String adjective)
    {
        this.createdDate = new Date();
        this.verb = verb;
        this.noun = noun;
        this.adjective = adjective;
        this.showsCount = 0;
    }

    public long getId()
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
