package com.gooddata.homework.services;

import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CheckWordImpl implements CheckWord
{
    private Set<String> forbiddenWords;

    private ResourceLoader resourceLoader;

    private final static String FILE_PATH_FW = "classpath:static/forbidden.words";

    public CheckWordImpl(ResourceLoader resourceLoader)
    {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public boolean isForbidden(String word)
    {
        return forbiddenWords.stream()
                .anyMatch(s ->  s.equals(word));
    }

    @Override
    public void refresh()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(
                resourceLoader.getResource(FILE_PATH_FW).getFile())))
        {
            forbiddenWords = reader.lines()
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .collect(Collectors.toSet());
        }
        catch(IOException e)
        {
            // I don't know why, but when I run via java -jar that cannot find the file.
            System.out.println(e.getMessage());
            forbiddenWords = new HashSet<>();
        }
    }
}
