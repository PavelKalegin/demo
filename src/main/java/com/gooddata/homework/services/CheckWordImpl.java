package com.gooddata.homework.services;

import com.gooddata.homework.models.WordEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CheckWordImpl implements CheckWord
{
    private Set<String> forbiddenWords;

    private long lastModifyDate;

    private final static String FILE_PATH_FW = "static/forbidden.words";

    public CheckWordImpl()
    {
        assert getClass().getClassLoader().getResource(FILE_PATH_FW) != null;
        File file = new File(getClass().getClassLoader().getResource(FILE_PATH_FW).getFile());
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            this.forbiddenWords = reader.lines().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toSet());
            this.lastModifyDate = file.lastModified();
        }
        catch(Exception e)
        {
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean isForbidden(String word)
    {
        refresh();
        return forbiddenWords.stream()
                .anyMatch(s ->  s.equals(word));
    }

    @Override
    public void refresh()
    {
        assert getClass().getClassLoader().getResource(FILE_PATH_FW) != null;
        File file = new File(getClass().getClassLoader().getResource(FILE_PATH_FW).getFile());
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            this.forbiddenWords = reader.lines().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toSet());
            this.lastModifyDate = file.lastModified();
        }
        catch(Exception e)
        {
            throw  new RuntimeException(e.getMessage());
        }
    }
}
