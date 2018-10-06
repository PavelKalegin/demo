package com.gooddata.homework.sentenses;

import com.gooddata.homework.words.WordCategory;
import com.gooddata.homework.words.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SentenceService
{
    @Autowired
    private WordService wordService;

    @Autowired
    private SentenceRepository sentenceRepository;

    public void generateSentence()
    {
        sentenceRepository.save(new SentenceEntity(
                wordService.getRandom(WordCategory.VERB).getWord(),
                wordService.getRandom(WordCategory.NOUN).getWord(),
                wordService.getRandom(WordCategory.ADJECTIVE).getWord()));
    }

    SentenceEntity getById(long id)
    {
        Optional<SentenceEntity> sentence = sentenceRepository.findById(id);
        sentence.ifPresent(sentenceEntity -> {
            sentenceEntity.increaseShowsCount();
            sentenceRepository.save(sentenceEntity);
        });
        return sentence.orElse(null);
    }

    Iterable<SentenceEntity> getSentences()
    {
        return sentenceRepository.findAll();
    }

}
