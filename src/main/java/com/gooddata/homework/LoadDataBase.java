package com.gooddata.homework;

import com.gooddata.homework.sentenses.SentenceService;
import com.gooddata.homework.words.WordCategory;
import com.gooddata.homework.words.WordEntity;
import com.gooddata.homework.words.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
public class LoadDataBase
{
    @Bean
    CommandLineRunner initDataBase(WordRepository wordRepository, SentenceService sentenceService)
    {
        return args -> {
            wordRepository.save(new WordEntity("Cat", WordCategory.NOUN));
            wordRepository.save(new WordEntity("Dog", WordCategory.NOUN));
            wordRepository.save(new WordEntity("Rat", WordCategory.NOUN));

            wordRepository.save(new WordEntity("is", WordCategory.VERB));
            wordRepository.save(new WordEntity("looks", WordCategory.VERB));
            wordRepository.save(new WordEntity("was", WordCategory.VERB));

            wordRepository.save(new WordEntity("animal", WordCategory.ADJECTIVE));
            wordRepository.save(new WordEntity("pretty", WordCategory.ADJECTIVE));
            wordRepository.save(new WordEntity("good", WordCategory.ADJECTIVE));

            IntStream.range(0, 100).forEach(i -> sentenceService.generateSentence());
        };
    }
}
