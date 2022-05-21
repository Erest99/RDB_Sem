package com.example.rdb_sem.notebookSQL;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity(name = "Product")  //pro hybernate
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

//    @Embedded
//    private Nekonzistence nekonzistence;

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long _id;

    @Column(name="prod_Id",updatable = false, unique = false,columnDefinition = "char(5)")
    private String prodId;

    // fizicke vlastnostni start
    @Column(name = "diagonal", nullable = false)
    private Float diagonal;

    @ManyToOne(
            //cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "resolution",
            referencedColumnName = "resolution"
    )
    private Resolution  resolution;

    @Column(name = "resolution_word", nullable = false,columnDefinition = "varchar(15)")
    private String resWord;


    @ManyToOne(
            //cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "color",
            referencedColumnName = "color"
    )
    private Color color;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "depth", nullable = false)
    private Integer depth;

    @Column(name = "weight", nullable = false)
    private Integer weight;
    //fyzicke vlastnosti end

    @Column(name = "processor_type", nullable = false,columnDefinition = "varchar(50)")
    private String processorType;

    @Column(name = "core_count", nullable = false)
    private Integer coreCount;

    @Column(name = "processor_freq", nullable = false)
    private Float processorFreq;

    @Column(name = "memory_type", nullable = false,columnDefinition = "varchar(15)")
    private String memoryType;

    @Column(name = "memory_size", nullable = false)
    private Integer memorySize;

    @Column(name = "hdd_type", nullable = false,columnDefinition = "varchar(15)")
    private String hddType;

    @Column(name = "hdd_size", nullable = false)
    private Integer hddSize;

    @Column(name = "gpu_type", nullable = false,columnDefinition = "varchar(50)")
    private String gpuType;

    @Column(name = "os", nullable = true,columnDefinition = "varchar(50)")
    private String os;

    @Column(name = "is_consistent", nullable = false,columnDefinition = "text" )
    private String isConsistent;


    public Product(String prodId, Float diagonal, Resolution resolution, String res_word, Color color, Integer height, Integer width, Integer depth, Integer weight, String processor_type, Integer core_count, Float processor_freq, String memory_type, Integer memory_size, String hdd_type, Integer hdd_size, String gpu_type, String os, String isConsistent) {
        this.prodId = prodId;
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.resWord = res_word;
        this.color = color;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.processorType = processor_type;
        this.coreCount = core_count;
        this.processorFreq = processor_freq;
        this.memoryType = memory_type;
        this.memorySize = memory_size;
        this.hddType = hdd_type;
        this.hddSize = hdd_size;
        this.gpuType = gpu_type;
        this.os = os;
        this.isConsistent = isConsistent;
    }


    public Product(String byProdId) {
    }
}
