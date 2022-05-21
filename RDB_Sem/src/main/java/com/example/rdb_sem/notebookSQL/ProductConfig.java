package com.example.rdb_sem.notebookSQL;

import com.example.rdb_sem.myMongo.Notebook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class ProductConfig {

    @Bean("bimport")
    @DependsOn({"ecolor","eresolution"})
    CommandLineRunner commandLineRunner(ProductRepository repository,ColorRepository colorRepository,ResolutionRepository resolutionRepository) throws FileNotFoundException {
        List<Product> products = DB.readCSV("src/main/java/com/example/rdb_sem/notebookSQL/export1651501890.csv");
        for (Product p : products) {
            if(repository.existsByProdId(p.getProdId())&&
                    repository.existsByCoreCount(p.getCoreCount())&&
                    repository.existsByDepth(p.getDepth())&&
                    repository.existsByDiagonal(p.getDiagonal())&&
                    repository.existsByGpuType(p.getGpuType())&&
                    repository.existsByHddSize(p.getHddSize())&&
                    repository.existsByHddType(p.getHddType())&&
                    repository.existsByHeight(p.getHeight())&&
                    repository.existsByMemorySize(p.getMemorySize())&&
                    repository.existsByMemoryType(p.getMemoryType())&&
                    repository.existsByOs(p.getOs())&&
                    repository.existsByProcessorFreq(p.getProcessorFreq())&&
                    repository.existsByProcessorType(p.getProcessorType())&&
                    repository.existsByResWord(p.getResWord())&&
                    repository.existsByWeight(p.getWeight())&&
                    repository.existsByWidth(p.getWidth())&&
                    repository.existsByResolution(p.getResolution())&&
                    repository.existsByColor(p.getColor())
            )
            {
                System.out.println("Duplikátní záznam pro: "+p+" ,neimportuji");
                products.remove(p);
            }
            else if(repository.existsByProdId(p.getProdId()))
            {
                System.out.println("WARNING: " +p + "is already in database");
                List<Product> kandidates = repository.findAllByProdId(p.getProdId());
                String isConsistent = isConsistentString(p,kandidates,repository);
                p.setIsConsistent(isConsistent);
                repository.save(p);
            }
            else if(!colorRepository.existsByColor(p.getColor().toString()))
            {
                System.out.println("color of "+p+" is not available");
                products.remove(p);
            }
            else if(!resolutionRepository.existsByResolution(p.getResolution().toString()))
            {
                System.out.println("resolution of "+p+" is not available");
                products.remove(p);
            }
        }
        repository.saveAll(products);
        return null;
    }

    private String isConsistentString(Product product,List<Product> ps, ProductRepository repository) {
        StringBuilder value = null;
        for (Product p : ps) {

            value= new StringBuilder(p.getIsConsistent());


            if (value.charAt(0)=='0') {



                if (product.getProdId().equals(p.getProdId())) value.setCharAt(0, '1');
                else value.setCharAt(0, '0');
                if (product.getDiagonal().equals(p.getDiagonal())) value.setCharAt(1, '0');
                else value.setCharAt(1, '1');
                if (product.getResolution().equals(p.getResolution())) value.setCharAt(2, '0');
                else value.setCharAt(2, '1');
                if (product.getProcessorType().equals(p.getProcessorType()))value.setCharAt(4, '0');
                else value.setCharAt(4, '1');
                if (product.getCoreCount().equals(p.getCoreCount())) value.setCharAt(5, '0');
                else value.setCharAt(5, '1');
                if (product.getProcessorFreq().equals(p.getProcessorFreq())) value.setCharAt(6, '0');
                else value.setCharAt(6, '1');
                if (product.getMemoryType().equals(p.getMemoryType())) value.setCharAt(7, '0');
                else value.setCharAt(7, '1');
                if (product.getMemorySize().equals(p.getMemorySize())) value.setCharAt(8, '0');
                else value.setCharAt(8, '1');
                if (product.getOs().equals(p.getOs())) value.setCharAt(9, '0');
                else value.setCharAt(9, '1');
                if (product.getHddSize().equals(p.getHddSize())) value.setCharAt(10, '0');
                else value.setCharAt(10, '1');
                if (product.getHddType().equals(p.getHddType())) value.setCharAt(11, '0');
                else value.setCharAt(11, '1');
                if (product.getGpuType().equals(p.getGpuType())) value.setCharAt(12, '0');
                else value.setCharAt(12, '1');
                if (product.getColor().equals(p.getColor())) value.setCharAt(13, '0');
                else value.setCharAt(13, '1');
                if (product.getHeight().equals(p.getHeight())) value.setCharAt(14, '0');
                else value.setCharAt(14, '1');
                if (product.getWidth().equals(p.getWidth())) value.setCharAt(15, '0');
                else value.setCharAt(15, '1');
                if (product.getDepth().equals(p.getDepth())) value.setCharAt(16, '0');
                else value.setCharAt(16, '1');
                if (product.getWeight().equals(p.getWeight())) value.setCharAt(17, '0');
                else value.setCharAt(17, '1');

                break;
            }
        }
        return value.toString();
    }


}
