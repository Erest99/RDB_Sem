package com.example.rdb_sem.notebookSQL;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Color {

    public Color(String color) {
        this.color = color;
    }

    @Id
    private String color;

    @Override
    public String toString() {
        return color;
    }

}