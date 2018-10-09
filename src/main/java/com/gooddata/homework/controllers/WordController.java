package com.gooddata.homework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooddata.homework.models.WordEntity;
import com.gooddata.homework.models.dto.WordDTO;
import com.gooddata.homework.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("words")
@SuppressWarnings("unused")
public class WordController
{
    @Autowired
    private WordService wordService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/")
    public Collection<WordDTO> getAllWords()
    {
        return wordService.getWordEntities();
    }

    @PutMapping("/{word}")
    public void addWord(@PathVariable String word, @RequestBody WordDTO wordDTO)
    {
        wordDTO.setWord(word);
        wordService.addWord(wordDTO);
    }

    @GetMapping("/{word}")
    public String findByWord(@PathVariable String word) throws JsonProcessingException
    {
        return mapper.writeValueAsString(wordService.findWord(word).orElse(null));
    }
}
