package com.gooddata.homework.words;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WordService
{
    private final List<WordEntity> wordEntities = new ArrayList<>();

    List<WordEntity> getWordEntities()
    {
        return wordEntities;
    }

    void addWord(WordEntity wordEntity)
    {
        wordEntities.add(wordEntity);
    }

    WordEntity findWord(String word)
    {
        return wordEntities.stream()
                .filter(wordEntity -> wordEntity.getWord().equals(word))
                .findAny().orElse(null);
    }

    public WordEntity getRandom(WordCategory wordCategory)
    {
        Random random = new Random();
        List<WordEntity> words = wordEntities.stream()
                .filter(wordEntity -> wordEntity.getWordCategory().equals(wordCategory))
                .collect(Collectors.toList());
        return words.get(random.nextInt(words.size()));
    }


}
