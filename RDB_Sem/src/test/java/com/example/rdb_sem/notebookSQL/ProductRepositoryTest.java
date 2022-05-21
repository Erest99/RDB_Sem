package com.example.rdb_sem.notebookSQL;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.rdb_sem.RdbSemApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@ContextConfiguration(classes= RdbSemApplication.class)
@DataJpaTest//data se v DB nezmění
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProduct()
    {

        System.out.println("----------");
        System.out.println("TEST BEZI");
        System.out.println("----------");

    }

//    @Test
//    public void printAllProducts()
//    {
//        List<Product> productList = productRepository.findAll();
//        System.out.println("product list: "+productList);
//    }

}