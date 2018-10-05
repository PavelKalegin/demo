package com.gooddata.homework.sentenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("sentences")
@SuppressWarnings("unused")
public class SentenceController
{
    @Autowired
    private SentenceService sentenceService;

    @GetMapping("/")
    public Collection<SentenceEntity> getAllSentences()
    {
        return sentenceService.getSentences();
    }

    @PostMapping("generate")
    public void generateSentence()
    {
        sentenceService.generateSentence();
    }

    @GetMapping("/{sentenceID}")
    public String getById(@PathVariable String id)
    {
        return sentenceService.getById(id).getSentence();
    }

    @GetMapping("/{sentenceID}/yodaTalk")
    public String getByIdYodaTalk(@PathVariable String id)
    {
        return sentenceService.getById(id).getYodaTalkSentence();
    }

}
