package com.gooddata.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unused")
public class UpdateForbiddenWordsTask
{
    @Autowired
    CheckWord checkWord;

    @Scheduled(fixedRate = 5000)
    public void refreshForbiddenWords()
    {
        //TODO: Handle UPDATE event on forbidden.words -> refresh list of forbidden words
    }
}
