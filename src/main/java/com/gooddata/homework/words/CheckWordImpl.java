package com.gooddata.homework.words;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CheckWordImpl implements CheckWord
{
    private List<String> forbiddenWords;

    private final static String FILE_PATH_FW = "static/forbidden.words";

    public CheckWordImpl()
    {
        try(BufferedReader reader
                    = new BufferedReader(
                new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(FILE_PATH_FW)).getFile())))
        {
            this.forbiddenWords = reader.lines().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
        }
        catch(Exception e)
        {
            throw  new RuntimeException(e.getMessage());
        }

    }

    @Override
    public boolean isForbidden(WordEntity wordEntity)
    {
        return forbiddenWords.stream()
                .anyMatch(s ->  wordEntity.getWord().equals(s));
    }
}
