package com.gooddata.homework;

import com.gooddata.homework.words.CheckWord;
import com.gooddata.homework.words.CheckWordImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig
{
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CheckWord getCheckWordService()
    {
        return new CheckWordImpl();
    }

}
