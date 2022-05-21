package com.example.rdb_sem.myMongo;

import com.example.rdb_sem.notebookSQL.Resolution;
import org.hibernate.criterion.Distinct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NotebookRepository extends MongoRepository<Notebook,String> {

    Optional<Notebook> findNotebookByScreen(Double screen);

    @Query("{ 'cpu' : ?0 }")
    List<Notebook> findNotebookByCpu(String cpu);

    List<Notebook> findAllByIsConsistentIsContaining(Boolean b);
//    @Query(SELECT DISTINCT Country FROM Customers)
//    List<String> findNotebookByResolution();

}
