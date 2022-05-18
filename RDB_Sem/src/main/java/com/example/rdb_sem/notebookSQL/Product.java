package com.example.rdb_sem.notebookSQL;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name="id",updatable = false, unique = true,columnDefinition = "char(5)")
    private String id;

    // fizicke vlastnostni start
    @Column(name = "diagonal", nullable = false)
    private Float diagonal;

    @Column(name = "resolution", nullable = false,columnDefinition = "varchar(15)")
//    @OneToOne
//    @JoinColumn(
//            name = "resolution",
//            referencedColumnName = "res_id"
//    )
    private String  resolution;

    @Column(name = "resolution_word", nullable = false,columnDefinition = "varchar(15)")
    private String res_word;

    @Column(name = "color", nullable = false,columnDefinition = "varchar(15)")
    @Enumerated(EnumType.STRING)
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
    private String processor_type;

    @Column(name = "core_count", nullable = false)
    private Integer core_count;

    @Column(name = "processor_freq", nullable = false)
    private Float processor_freq;

    @Column(name = "memory_type", nullable = false,columnDefinition = "varchar(15)")
    private String memory_type;

    @Column(name = "memory_size", nullable = false)
    private Integer memory_size;

    @Column(name = "hdd_type", nullable = false,columnDefinition = "varchar(15)")
    private String hdd_type;

    @Column(name = "hdd_size", nullable = false)
    private Integer hdd_size;

    @Column(name = "gpu_type", nullable = false,columnDefinition = "varchar(50)")
    private String gpu_type;

    @Column(name = "os", nullable = true,columnDefinition = "varchar(50)")
    private String os;

    @Column(name = "is_consistent", nullable = false,columnDefinition = "boolean" )
    private Boolean isConsistent;




//    public Product(String id, Float diagonal, String resolution, String res_word, String color, Integer height, Integer width, Integer depth, Integer weight, String processor_type, Integer core_count, Float processor_freq, String memory_type, Integer memory_size, String hdd_type, Integer hdd_size, String gpu_type, String os) {
//        this.id = id;
//        this.diagonal = diagonal;
//        this.resolution = resolution;
//        this.res_word = res_word;
//        this.color = color;
//        this.height = height;
//        this.width = width;
//        this.depth = depth;
//        this.weight = weight;
//        this.processor_type = processor_type;
//        this.core_count = core_count;
//        this.processor_freq = processor_freq;
//        this.memory_type = memory_type;
//        this.memory_size = memory_size;
//        this.hdd_type = hdd_type;
//        this.hdd_size = hdd_size;
//        this.gpu_type = gpu_type;
//        this.os = os;
//    }
//
//    public Product() {
//
//    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", diagonal=" + diagonal +
                ", resolution='" + resolution + '\'' +
                ", res_word='" + res_word + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", weight=" + weight +
                ", processor_type='" + processor_type + '\'' +
                ", core_count=" + core_count +
                ", processor_freq=" + processor_freq +
                ", memory_type='" + memory_type + '\'' +
                ", memory_size=" + memory_size +
                ", hdd_type='" + hdd_type + '\'' +
                ", hdd_size=" + hdd_size +
                ", gpu_type='" + gpu_type + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Float getDiagonal() {
//        return diagonal;
//    }
//
//    public void setDiagonal(Float diagonal) {
//        this.diagonal = diagonal;
//    }
//
//    public String getResolution() {
//        return resolution;
//    }
//
//    public void setResolution(String resolution) {
//        this.resolution = resolution;
//    }
//
//    public String getRes_word() {
//        return res_word;
//    }
//
//    public void setRes_word(String res_word) {
//        this.res_word = res_word;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Integer getHeight() {
//        return height;
//    }
//
//    public void setHeight(Integer height) {
//        this.height = height;
//    }
//
//    public Integer getWidth() {
//        return width;
//    }
//
//    public void setWidth(Integer width) {
//        this.width = width;
//    }
//
//    public Integer getDepth() {
//        return depth;
//    }
//
//    public void setDepth(Integer depth) {
//        this.depth = depth;
//    }
//
//    public Integer getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Integer weight) {
//        this.weight = weight;
//    }
//
//    public String getProcessor_type() {
//        return processor_type;
//    }
//
//    public void setProcessor_type(String processor_type) {
//        this.processor_type = processor_type;
//    }
//
//    public Integer getCore_count() {
//        return core_count;
//    }
//
//    public void setCore_count(Integer core_count) {
//        this.core_count = core_count;
//    }
//
//    public Float getProcessor_freq() {
//        return processor_freq;
//    }
//
//    public void setProcessor_freq(Float processor_freq) {
//        this.processor_freq = processor_freq;
//    }
//
//    public String getMemory_type() {
//        return memory_type;
//    }
//
//    public void setMemory_type(String memory_type) {
//        this.memory_type = memory_type;
//    }
//
//    public Integer getMemory_size() {
//        return memory_size;
//    }
//
//    public void setMemory_size(Integer memory_size) {
//        this.memory_size = memory_size;
//    }
//
//    public String getHdd_type() {
//        return hdd_type;
//    }
//
//    public void setHdd_type(String hdd_type) {
//        this.hdd_type = hdd_type;
//    }
//
//    public Integer getHdd_size() {
//        return hdd_size;
//    }
//
//    public void setHdd_size(Integer hdd_size) {
//        this.hdd_size = hdd_size;
//    }
//
//    public String getGpu_type() {
//        return gpu_type;
//    }
//
//    public void setGpu_type(String gpu_type) {
//        this.gpu_type = gpu_type;
//    }
//
//    public String getOs() {
//        return os;
//    }
//
//    public void setOs(String os) {
//        this.os = os;
//    }
}
