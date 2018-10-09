package com.gooddata.homework.models.repositories;

import com.gooddata.homework.models.SetOfWordsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SetOfWordsRepository extends CrudRepository<SetOfWordsEntity, Long>
{
    Optional<SetOfWordsEntity> findByNounAndVerbAndAdjective(String noun, String verb, String adjective);
}
