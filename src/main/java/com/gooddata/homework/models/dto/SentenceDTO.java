package com.gooddata.homework.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("sentence")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT ,use = JsonTypeInfo.Id.NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SentenceDTO
{
    @JsonIgnore
    private long id;

    private String text;

    private Integer showsCount;

    public SentenceDTO(long id, String text, Integer showsCount)
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

    public Integer getShowsCount()
    {
        return showsCount;
    }

    public void setShowsCount(Integer showsCount)
    {
        this.showsCount = showsCount;
    }
}
