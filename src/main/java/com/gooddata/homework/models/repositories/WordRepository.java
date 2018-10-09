package com.gooddata.homework.models.repositories;


import com.gooddata.homework.models.WordEntity;
import com.gooddata.homework.models.WordCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface WordRepository extends CrudRepository<WordEntity, String>
{
    Stream<WordEntity> findAllByWordCategory(WordCategory wordCategory);
}
