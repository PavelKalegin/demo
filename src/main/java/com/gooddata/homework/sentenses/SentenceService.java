package com.gooddata.homework.sentenses;

import com.gooddata.homework.sentenses.wordsets.SetOfWordsEntity;
import com.gooddata.homework.sentenses.wordsets.SetOfWordsRepository;
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

    @Autowired
    private SetOfWordsRepository setOfWordsRepository;

    public void generateSentence()
    {
        String noun  = wordService.getRandom(WordCategory.NOUN).getWord();
        String verb = wordService.getRandom(WordCategory.VERB).getWord();
        String adjective = wordService.getRandom(WordCategory.ADJECTIVE).getWord();

        sentenceRepository.save(
                new SentenceEntity(setOfWordsRepository
                        .findByNounAndVerbAndAdjective(noun, verb, adjective)
                        .orElseGet(() -> setOfWordsRepository.save(new SetOfWordsEntity(noun, verb, adjective))))
        );
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
