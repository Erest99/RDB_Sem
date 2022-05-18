package com.example.rdb_sem.notebookSQL;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest//data se v DB nezmění
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProduct()
    {
        Color color = Color.grey;
        Product product = Product.builder()
                .id("BBBBB")
                .diagonal(15.0f)
                .resolution("1920 x 1080")
                .res_word("FULL HD")
                .color(color)
                .height(300)
                .width(300)
                .depth(300)
                .weight(2)
                .processor_type("some processor")
                .core_count(6)
                .processor_freq(3.7f)
                .memory_type("some memory")
                .memory_size(20)
                .hdd_type("SSD")
                .hdd_size(2000)
                .gpu_type("GTX2060")
                .os(null)
                .isConsistent(true)
                .build();

        productRepository.save(product);

    }

//    @Test
//    public void printAllProducts()
//    {
//        List<Product> productList = productRepository.findAll();
//        System.out.println("product list: "+productList);
//    }

}