package com.gooddata.homework.words;

@SuppressWarnings("WeakerAccess")
public class WordEntity
{
    private String word;

    private WordCategory wordCategory;

    WordEntity(String word, WordCategory wordCategory)
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
}
