package com.gooddata.homework.services;

import com.gooddata.homework.models.SentenceEntity;
import com.gooddata.homework.models.SentenceView;
import com.gooddata.homework.models.SetOfWordsEntity;
import com.gooddata.homework.models.WordCategory;
import com.gooddata.homework.models.dto.SentenceDTO;
import com.gooddata.homework.models.repositories.SentenceRepository;
import com.gooddata.homework.models.repositories.SetOfWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class SentenceService
{
    @Autowired
    private WordService wordService;

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private SetOfWordsRepository setOfWordsRepository;

    @Transactional
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

    public Optional<SentenceDTO> getById(long id, SentenceView sentenceView)
    {
        return sentenceRepository.findById(id).map(
                sentenceEntity -> {
                    sentenceEntity.setShowsCount(sentenceEntity.getShowsCount() + 1);
                    sentenceRepository.save(sentenceEntity);
                    return new SentenceDTO(getSentenceText(sentenceEntity, sentenceView),
                            getShowsCount(sentenceEntity, sentenceView));
                }
        );
    }

    public Iterable<SentenceDTO> getSentences()
    {
        return StreamSupport.stream(sentenceRepository.findAll().spliterator(), false)
                .map(SentenceDTO::new)::iterator;
    }

    private String getSentenceText(SentenceEntity sentence, SentenceView sentenceView)
    {
        switch(sentenceView)
        {
            case NORMAL: return sentence.getSetOfWordsEntity().getNoun() + " "
                    + sentence.getSetOfWordsEntity().getVerb() + " "
                    + sentence.getSetOfWordsEntity().getAdjective();
            case YODA_TALK: return sentence.getSetOfWordsEntity().getAdjective() + " "
                    + sentence.getSetOfWordsEntity().getNoun() + " "
                    + sentence.getSetOfWordsEntity().getVerb();
            default: throw new RuntimeException("Unsupported sentence view " + sentenceView.toString());
        }
    }

    private Integer getShowsCount(SentenceEntity sentence, SentenceView sentenceView)
    {
        switch(sentenceView)
        {
            case NORMAL: return sentence.getShowsCount();
            case YODA_TALK: return null;
            default: throw new RuntimeException("Unsupported sentence view " + sentenceView.toString());
        }
    }
}
