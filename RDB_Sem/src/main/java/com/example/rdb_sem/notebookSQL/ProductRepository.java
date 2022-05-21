package com.example.rdb_sem.notebookSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Optional<Product> findProductByNameAndState(String id);
    Boolean existsByProdId(String prodId);
    Boolean existsByCoreCount(Integer core_count);
    Boolean existsByDepth(Integer depth);
    Boolean existsByDiagonal(Float diagonal);
    Boolean existsByGpuType(String gpu_type);
    Boolean existsByHddSize(Integer hdd_size);
    Boolean existsByHddType(String hdd_type);
    Boolean existsByHeight(Integer height);
    Boolean existsByMemorySize(Integer memory_size);
    Boolean existsByMemoryType(String memory_type);
    Boolean existsByOs(String os);
    Boolean existsByProcessorFreq(Float processor_freq);
    Boolean existsByProcessorType(String processor_type);
    Boolean existsByResWord(String res_word);
    Boolean existsByWeight(Integer weight);
    Boolean existsByWidth(Integer width);
    Boolean existsByResolution(Resolution resolution);
    Boolean existsByColor(Color color);
    List<Product> findAllByProdId(String prodId);

    String getByProdId(String prodId);


}
