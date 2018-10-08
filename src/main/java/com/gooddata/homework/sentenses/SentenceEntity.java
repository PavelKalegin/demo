package com.gooddata.homework.sentenses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gooddata.homework.sentenses.wordsets.SetOfWordsEntity;

import javax.persistence.CascadeType;
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

    SentenceEntity(SetOfWordsEntity setOfWords)
    {
        this.setOfWordsEntity = setOfWords;
        this.createdDate = new Date();
        this.showsCount = 0;
    }

    public long getId()
    {
        return id;
    }

    public String getText()
    {
        return setOfWordsEntity.getNoun() + " " + setOfWordsEntity.getVerb() + " " + setOfWordsEntity.getAdjective();
    }

    public String getYodaText()
    {
        return setOfWordsEntity.getAdjective() + " " + setOfWordsEntity.getNoun() + " " + setOfWordsEntity.getVerb();
    }

    public void increaseShowsCount()
    {
        this.showsCount++;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public Integer getShowsCount()
    {
        return showsCount;
    }
}
