package com.example.rdb_sem.notebookSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DB  {



    public static Map<String, Product> convertListToMap(List<Product> list) {
        return list.stream()
                .collect(Collectors.toMap(Product::getProdId, Function.identity()));
    }

    public static List<Product> readCSV(String fileName) throws FileNotFoundException {
        List<Product> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
            return records;
        }
    }

    private static Product getRecordFromLine(String line) {
        String[] parts = line.split(",");

        String id =  parts[0];
        Float diagonal =  Float.valueOf(parts[1]);
        Resolution resolution = new Resolution(parts[2]);
        String resolution_word = parts[3];
        String processor_type = parts[4];
        Integer core_count = Integer.valueOf(parts[5]);
        String memory_type = parts[6];
        Float processor_freq = Float.valueOf(parts[7]);
        Integer memory_size = Integer.valueOf(parts[8]);
        String os = parts[9]; //operacni system
        Integer hdd_size = Integer.valueOf(parts[10]);
        String hdd_type = parts[11];
        String gpu_type = parts[12];
        Color color = new Color(parts[13]);
        Integer height = Integer.valueOf(parts[14]);
        Integer width = Integer.valueOf(parts[15]);
        Integer depth = Integer.valueOf(parts[16]);
        Integer weight = Integer.valueOf(parts[17]);
        String isConsistent = checkResolutionConsistency(parts[2],resolution_word);

        return new Product(
                id, diagonal, resolution, resolution_word,
                color, height, width, depth,
                weight, processor_type, core_count,
                processor_freq, memory_type, memory_size,
                hdd_type, hdd_size, gpu_type, os,isConsistent
        );
    }

    private static String checkResolutionConsistency(String resolution,String res_word)
    {
        StringBuilder value = new StringBuilder("000000000000000000");
        if(resolution.equals("1920 x 1080")  && res_word.equals("Full HD"))value.setCharAt(3, '0');
        else if(resolution.equals("1366 x 768") && res_word.equals("HD"))value.setCharAt(3, '0');
        else if(resolution.equals("1280 x 800") && res_word.equals("WXGA"))value.setCharAt(3, '0');
        else if(resolution.equals("2560 x 1440") && res_word.equals("WQHD"))value.setCharAt(3, '0');
        else if(resolution.equals("3200 x 1800") && res_word.equals("QHD +"))value.setCharAt(3, '0');
        else if(resolution.equals("3840 x 2160") && res_word.equals("UHD 4K0"))value.setCharAt(3, '0');
        else value.setCharAt(3, '1');

        return value.toString();
    }



}
