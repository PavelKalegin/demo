package com.gooddata.homework.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.homework.models.SentenceEntity;

import java.util.Date;

@JsonTypeName("sentence")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT ,use = JsonTypeInfo.Id.NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class SentenceDTO
{
    private Long sentenceID;

    private String text;

    private Integer showsCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date createdDate;

    public SentenceDTO(String text, Integer showsCount)
    {
        this.text = text;
        this.showsCount = showsCount;
    }

    public SentenceDTO(SentenceEntity sentenceEntity)
    {
        this.sentenceID = sentenceEntity.getId();
        this.text = sentenceEntity.getSetOfWordsEntity().getNoun() + " "
                + sentenceEntity.getSetOfWordsEntity().getVerb() + " "
                + sentenceEntity.getSetOfWordsEntity().getAdjective();
        this.showsCount = sentenceEntity.getShowsCount();
        this.createdDate = sentenceEntity.getCreatedDate();
    }

    public SentenceDTO()
    {

    }

    public Long getSentenceID()
    {
        return sentenceID;
    }

    public void setSentenceID(Long sentenceID)
    {
        this.sentenceID = sentenceID;
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

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }
}
