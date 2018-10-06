package com.gooddata.homework.words;


import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface WordRepository extends CrudRepository<WordEntity, String>
{
    Stream<WordEntity> findAllByWordCategory(WordCategory wordCategory);
}
