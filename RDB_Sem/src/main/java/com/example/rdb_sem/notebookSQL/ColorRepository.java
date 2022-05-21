package com.example.rdb_sem.notebookSQL;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,String> {
    Boolean existsByColor(String color);
}
