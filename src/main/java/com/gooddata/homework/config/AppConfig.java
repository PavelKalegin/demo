package com.gooddata.homework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooddata.homework.services.CheckWord;
import com.gooddata.homework.services.CheckWordImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;

@Configuration
@SuppressWarnings({"unused"})
public class AppConfig
{
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CheckWord getCheckWordService()
    {
        CheckWord checkWord = new CheckWordImpl(resourceLoader);
        checkWord.refresh();
        return checkWord;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper getObjectMapper()
    {
        return new ObjectMapper();
    }
}
