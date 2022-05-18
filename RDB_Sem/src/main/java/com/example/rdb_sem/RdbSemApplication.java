package com.example.rdb_sem;

import com.example.rdb_sem.myMongo.Notebook;
import com.example.rdb_sem.myMongo.NotebookRepository;
import com.example.rdb_sem.notebookSQL.Color;
import com.example.rdb_sem.notebookSQL.DB;
import com.example.rdb_sem.notebookSQL.Product;
import com.example.rdb_sem.notebookSQL.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class RdbSemApplication {

    public static void main(String[] args) throws FileNotFoundException {
//        List< Product> neco = DB.readCSV("src/main/java/com/example/rdb_sem/notebookSQL/export1651501890.csv");
        SpringApplication.run(RdbSemApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunnerSQL(ProductRepository productRepository)
    {
        return args -> {
        //Product testProduct = new Product("AAAAA",15.0f,"1920 x 1080","FULL HD", Color.grey,300,300,300,2,"some processor",6,3.7f,"some memory",20,"SSD",2000,"GTX2060",null,true);
        //productRepository.save(testProduct);
        };
    }
//    @Bean
//    CommandLineRunner runner(NotebookRepository repository, MongoTemplate mongoTemplate)
//    {
//        String product_id ="I3TS9";
//        Double diagonal = 14.0;
//        return args -> {
//            Notebook notebook = new Notebook(product_id,diagonal,"1366x768",
//                    "Full HD","Intel core",4,2.4,"DDR4 SODIMM",
//                    12,"",1313,"SSHD","NVIDIA GeForce GTX 1070", Color.RED,17,375,300,4);
//            usingMongoTemplateAndQuery(repository, mongoTemplate, product_id, notebook);
//            //repository.findNotebookByDiagonal(diagonal).ifPresentOrElse(notebook1 ->{},()-> {});
//        };

//    }

//    private void usingMongoTemplateAndQuery(NotebookRepository repository, MongoTemplate mongoTemplate, String product_id, Notebook notebook) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("product_id").is(product_id));
//
//        List<Notebook> notebooks = mongoTemplate.find(query,Notebook.class);
//        if(notebooks.size()>1)
//        {
//            throw new IllegalStateException("Multiple products with id: "+ product_id);
//        }
//        if(notebooks.isEmpty())
//        {
//            System.out.println("Inserting product " + notebook);
//            repository.insert(notebook);
//        }
//        else
//        {
//            System.out.println((notebook +" is already in database"));
//        }
//    }

}
