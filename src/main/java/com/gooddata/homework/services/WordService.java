package com.gooddata.homework.services;

import com.gooddata.homework.exceptions.ForbiddenWordUsingException;
import com.gooddata.homework.exceptions.WordNotFoundException;
import com.gooddata.homework.models.WordCategory;
import com.gooddata.homework.models.WordEntity;
import com.gooddata.homework.models.dto.WordDTO;
import com.gooddata.homework.models.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class WordService
{
    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private CheckWord checkWord;


    public Collection<WordDTO> getWordEntities()
    {
        return StreamSupport.stream(wordRepository.findAll().spliterator(), false)
                .map(WordDTO::new)
                .collect(Collectors.toCollection(LinkedList::new));

    }

    public void addWord(WordDTO wordDTO)
    {
        assert wordDTO != null;
        if(checkWord.isForbidden(wordDTO.getWord()))
        {
            throw new ForbiddenWordUsingException(wordDTO.getWord());
        }
        wordRepository.save(new WordEntity(wordDTO.getWord(), wordDTO.getWordCategory()));
    }

    public Optional<WordDTO> findWord(String word)
    {
        return wordRepository.findById(word).map(WordDTO::new);
    }

    /**
    * TODO: explain it!
     */
    @Transactional
    WordEntity getRandom(WordCategory wordCategory) throws WordNotFoundException
    {
        try(Stream<WordEntity> stream = wordRepository.findAllByWordCategory(wordCategory))
        {
            int count = (int) stream.count();
            if (count == 0)
                throw new WordNotFoundException(wordCategory);
            return wordRepository.findAllByWordCategory(wordCategory)
                    .skip(new Random().nextInt(count))
                    .findAny()
                    .orElseThrow(() -> new WordNotFoundException(wordCategory));
        }
    }

}
