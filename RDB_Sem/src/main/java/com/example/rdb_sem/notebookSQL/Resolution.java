package com.example.rdb_sem.notebookSQL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resolution {

    public Resolution(String mresolution) {
        this.mresolution = mresolution;
    }

    @Id
    @SequenceGenerator(
            name = "res_sequence",
            sequenceName = "res_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "res_sequence"

    )
    private Long res_id;
    private String mresolution;
    //TODO opravit relation 1to1
//    @OneToOne
//    @JoinColumn(
//            name = "id",
//            referencedColumnName = "id"
//    )
//    private Product product;

}
