package com.gooddata.homework.models.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.homework.models.WordCategory;
import com.gooddata.homework.models.WordEntity;

@JsonTypeName("word")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT ,use = JsonTypeInfo.Id.NAME)
public class WordDTO
{
    private String word;

    private WordCategory wordCategory;

    public WordDTO()
    {

    }

    public WordDTO(WordEntity wordEntity)
    {
        assert wordEntity != null;
        this.word = wordEntity.getWord();
        this.wordCategory = wordEntity.getWordCategory();
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public WordCategory getWordCategory()
    {
        return wordCategory;
    }

    public void setWordCategory(WordCategory wordCategory)
    {
        this.wordCategory = wordCategory;
    }
}
