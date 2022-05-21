package com.example.rdb_sem.notebookSQL;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Resolution {

    public Resolution(String resolution) {
        this.resolution = resolution;
    }

    @Id
    private String resolution;

    @Override
    public String toString() {
        return resolution;
    }
}
