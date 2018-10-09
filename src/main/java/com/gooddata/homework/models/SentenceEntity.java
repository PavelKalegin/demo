package com.gooddata.homework.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@SuppressWarnings({"WeakerAccess", "unused"})
public class SentenceEntity
{
    @Id
    @GeneratedValue
    private long id;

    private Date createdDate;

    @OneToOne
    private SetOfWordsEntity setOfWordsEntity;

    private Integer showsCount;

    public SentenceEntity()
    {
        this.createdDate = new Date();
    }

    public SentenceEntity(SetOfWordsEntity setOfWords)
    {
        this.setOfWordsEntity = setOfWords;
        this.createdDate = new Date();
        this.showsCount = 0;
    }

    public long getId()
    {
        return id;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public Integer getShowsCount()
    {
        return showsCount;
    }

    public SetOfWordsEntity getSetOfWordsEntity()
    {
        return setOfWordsEntity;
    }

    public void setSetOfWordsEntity(SetOfWordsEntity setOfWordsEntity)
    {
        this.setOfWordsEntity = setOfWordsEntity;
    }

    public void setShowsCount(Integer showsCount)
    {
        this.showsCount = showsCount;
    }
}
