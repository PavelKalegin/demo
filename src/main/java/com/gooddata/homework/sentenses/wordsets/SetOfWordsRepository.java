package com.gooddata.homework.sentenses.wordsets;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SetOfWordsRepository extends CrudRepository<SetOfWordsEntity, Long>
{
    Optional<SetOfWordsEntity> findByNounAndVerbAndAdjective(String noun, String verb, String adjective);
}
