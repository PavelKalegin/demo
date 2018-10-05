package com.gooddata.homework.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("words")
@SuppressWarnings("unused")
public class WordController
{
    @Autowired
    private WordService wordService;

    @GetMapping("/")
    public List<WordEntity> getAllWords()
    {
        return wordService.getWordEntities();
    }

    @PutMapping("/{word}")
    public void addWord(@PathVariable String word, @RequestBody @Validated(WordCategory.class) WordCategory wordCategory)
    {
        wordService.addWord(new WordEntity(word, wordCategory));
    }

    @GetMapping("/{word}")
    public WordEntity findByWord(@PathVariable String word)
    {
        return wordService.findWord(word);
    }
}
