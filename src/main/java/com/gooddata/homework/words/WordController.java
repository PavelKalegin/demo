package com.gooddata.homework.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("words")
@SuppressWarnings("unused")
public class WordController
{
    @Autowired
    private WordService wordService;

    @GetMapping("/")
    public Iterable<WordEntity> getAllWords()
    {
        return wordService.getWordEntities();
    }

    @PutMapping("/{word}")
    public void addWord(@PathVariable String word, @RequestBody WordEntity wordEntity)
    {
        wordEntity.setWord(word);
        wordService.addWord(wordEntity);
    }

    @GetMapping("/{word}")
    public WordEntity findByWord(@PathVariable String word)
    {
        return wordService.findWord(word).orElse(null);
    }
}
