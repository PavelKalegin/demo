package com.gooddata.homework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooddata.homework.services.CheckWord;
import com.gooddata.homework.services.CheckWordImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@SuppressWarnings({"unused"})
public class AppConfig
{
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CheckWord getCheckWordService()
    {
        return new CheckWordImpl();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper getObjectMapper()
    {
        return new ObjectMapper();
    }
}
