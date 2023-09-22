/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.springdatarestdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author scott
 */
@Configuration
public class DateFormatterConfiguration {
    
    @Value("${dateServices.date.format}")
    private String dateFormat;

    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
        mapper.setDateFormat(new SimpleDateFormat(dateFormat));
        return mapper;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        df.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }
}
