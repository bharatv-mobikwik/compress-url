package com.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextListener;

/**
 * Created by MOBIKWIK\omk707 on 17/7/17.
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"com"}, excludeFilters = {@ComponentScan.Filter(value = {Configuration.class, Controller.class})})
public class UrlShortenerAppContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
