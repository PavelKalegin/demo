package com.gooddata.homework.words;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SuppressWarnings({"WeakerAccess", "unused"})
public class WordEntity
{
    @Id
    private String word;

    private WordCategory wordCategory;

    public WordEntity()
    {
    }

    public WordEntity(String word, WordCategory wordCategory)
    {
        this.word = word;
        this.wordCategory = wordCategory;
    }

    public String getWord()
    {
        return word;
    }

    public WordCategory getWordCategory()
    {
        return wordCategory;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public void setWordCategory(WordCategory wordCategory)
    {
        this.wordCategory = wordCategory;
    }
}
