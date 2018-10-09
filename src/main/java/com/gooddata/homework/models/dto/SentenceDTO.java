package com.gooddata.homework.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SentenceDTO
{
    @JsonIgnore
    private long id;

    private String text;

    private int showsCount;

    public SentenceDTO(long id, String text, int showsCount)
    {
        this.id = id;
        this.text = text;
        this.showsCount = showsCount;
    }

    public SentenceDTO()
    {

    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getShowsCount()
    {
        return showsCount;
    }

    public void setShowsCount(int showsCount)
    {
        this.showsCount = showsCount;
    }
}
