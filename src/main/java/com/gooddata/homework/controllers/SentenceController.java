package com.gooddata.homework.controllers;

import com.gooddata.homework.models.SentenceEntity;
import com.gooddata.homework.models.SentenceView;
import com.gooddata.homework.models.dto.SentenceDTO;
import com.gooddata.homework.services.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sentences")
@SuppressWarnings("unused")
public class SentenceController
{
    @Autowired
    private SentenceService sentenceService;

    @GetMapping("/")
    public Iterable<SentenceEntity> getAllSentences()
    {
        return sentenceService.getSentences();
    }

    @PostMapping("generate")
    public void generateSentence()
    {
        sentenceService.generateSentence();
    }

    @GetMapping("/{sentenceID}")
    public SentenceDTO getById(@PathVariable Long sentenceID)
    {
        return sentenceService.getById(sentenceID, SentenceView.NORMAL).orElse(null);
    }

    @GetMapping("/{sentenceID}/yodaTalk")
    public SentenceDTO getByIdYodaTalk(@PathVariable Long sentenceID)
    {
        return sentenceService.getById(sentenceID, SentenceView.YODA_TALK).orElse(null);
    }

}
