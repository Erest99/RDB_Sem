package com.example.rdb_sem.myMongo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@Builder
public class MonColor {

    public MonColor(String color) {
        this.color = color;
    }

    @Id
    private String color;

    @Override
    public String toString() {
        return color;
    }

}