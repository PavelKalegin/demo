package com.gooddata.homework.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"noun", "verb", "adjective"})})
public class SetOfWordsEntity
{
    @Id
    @GeneratedValue
    long id;

    private String noun;

    private String verb;

    private String adjective;

    public SetOfWordsEntity()
    {
    }

    public SetOfWordsEntity(String noun, String verb, String adjective)
    {
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
    }

    public String getNoun()
    {
        return noun;
    }

    public void setNoun(String noun)
    {
        this.noun = noun;
    }

    public String getVerb()
    {
        return verb;
    }

    public void setVerb(String verb)
    {
        this.verb = verb;
    }

    public String getAdjective()
    {
        return adjective;
    }

    public void setAdjective(String adjective)
    {
        this.adjective = adjective;
    }
}
