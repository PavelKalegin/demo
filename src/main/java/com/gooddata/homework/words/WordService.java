package com.gooddata.homework.words;

import com.gooddata.homework.words.exceptions.ForbiddenWordUsingException;
import com.gooddata.homework.words.exceptions.WordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class WordService
{
    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private CheckWordImpl checkWord;


    Iterable<WordEntity> getWordEntities()
    {
        return wordRepository.findAll();
    }

    void addWord(WordEntity wordEntity)
    {
        if(checkWord.isForbidden(wordEntity))
        {
            throw new ForbiddenWordUsingException(wordEntity.getWord());
        }
        wordRepository.save(wordEntity);
    }

    Optional<WordEntity> findWord(String word)
    {
        return wordRepository.findById(word);
    }

    /**
    * TODO: explain it!
     */
    @Transactional
    public WordEntity getRandom(WordCategory wordCategory) throws WordNotFoundException
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
