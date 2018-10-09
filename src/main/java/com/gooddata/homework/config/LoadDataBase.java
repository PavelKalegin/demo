package com.gooddata.homework.config;

import com.gooddata.homework.models.WordCategory;
import com.gooddata.homework.models.WordEntity;
import com.gooddata.homework.models.repositories.WordRepository;
import com.gooddata.homework.services.SentenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@Configuration
public class LoadDataBase
{
    @Bean
    @Transactional
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
