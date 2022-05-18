package com.example.rdb_sem.notebookSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) throws FileNotFoundException {
        //List<Product> products = DB.readCSV("src/main/java/com/example/rdb_sem/notebookSQL/export1651501890.csv");
        List<Product> products = DB.readCSV("src/main/java/com/example/rdb_sem/notebookSQL/testExport.csv");

        repository.saveAll(products);
        return null;
    }
}
