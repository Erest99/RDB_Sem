package com.example.rdb_sem.notebookSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.util.List;

@Configuration
public class ColorConfig {

    @Bean("ecolor")
    CommandLineRunner commandLineRunner3(ColorRepository repository) throws FileNotFoundException {
        List<Color> list = List.of(

                new Color(
                        "red"
                ),
                new Color(
                        "grey"
                ),
                new Color(
                        "silver"
                ),
                new Color(
                        "black"
                ),
                new Color(
                        "white"
                )



        );
        repository.saveAll(list);

        return null;
    }

}