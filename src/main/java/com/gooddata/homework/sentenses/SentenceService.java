package com.gooddata.homework.sentenses;

import com.gooddata.homework.words.WordCategory;
import com.gooddata.homework.words.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
class SentenceService
{
    private Map<String, SentenceEntity> sentences = new HashMap<>();

    @Autowired
    private WordService wordService;

    void generateSentence()
    {
        SentenceEntity entity = new SentenceEntity(
                wordService.getRandom(WordCategory.VERB).getWord(),
                wordService.getRandom(WordCategory.NOUN).getWord(),
                wordService.getRandom(WordCategory.ADJECTIVE).getWord());
        sentences.put(entity.getId(), entity);
    }

    SentenceEntity getById(String id)
    {
        SentenceEntity sentence = null;
        if (sentences.containsKey(id))
        {
            sentence = sentences.get(id);
            sentence.increaseShowsCount();
        }
        return sentence;
    }

    Collection<SentenceEntity> getSentences()
    {
        return sentences.values();
    }

}
