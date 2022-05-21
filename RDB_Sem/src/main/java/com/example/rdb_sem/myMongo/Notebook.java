package com.example.rdb_sem.myMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Data
@Document
public class Notebook {
    @Id
    //@Indexed(unique = true)
    private String id;
    @Column(name="serial",updatable = false, unique = false,columnDefinition = "char(5)")
    private String serial;
    private Double screen;
    private String resolution;
    private String resolution_code;
    private String cpu;
    private Integer cores;
    private Double cpu_freq;
    private String ram;
    private Integer ram_capacity;
    private String os;
    private Integer hdd;
    private String hdd_type;
    private String gpu;
    private String color;
    private Integer height;
    private Integer width;
    private Integer depth;
    private Integer weight;
    private Boolean[] isConsistent;

    public Notebook(String serial, Double screen, String resolution, String resolution_code, String cpu, Integer cores, Double cpu_freq, String ram, Integer ram_capacity, String os, Integer hdd, String hdd_type, String gpu, String color, Integer height, Integer width, Integer depth, Integer weight, Boolean[] isConsistent) {
        this.serial = serial;
        this.screen = screen;
        this.resolution = resolution;
        this.resolution_code = resolution_code;
        this.cpu = cpu;
        this.cores = cores;
        this.cpu_freq = cpu_freq;
        this.ram = ram;
        this.ram_capacity = ram_capacity;
        this.os = os;
        this.hdd = hdd;
        this.hdd_type = hdd_type;
        this.gpu = gpu;
        this.color = color;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.isConsistent = isConsistent;
    }
}
