package com.example.rdb_sem.notebookSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;

import java.io.FileNotFoundException;
import java.util.List;

@Configuration
public class ResolutionConfig {

    @Bean("eresolution")
    CommandLineRunner commandLineRunner2(ResolutionRepository repository) throws FileNotFoundException {
        List<Resolution> list = List.of(

                new Resolution(
                        "1920 x 1080"
                ),
                new Resolution(
                        "1280 x 800"
                ),
                new Resolution(
                        "1366 x 768"
                ),
                new Resolution(
                        "3200 x 1800"
                ),
                new Resolution(
                        "3840 x 2160"
                ),
                new Resolution(
                        "2560 x 1440"
                )



        );
        repository.saveAll(list);

        return null;
    }

}