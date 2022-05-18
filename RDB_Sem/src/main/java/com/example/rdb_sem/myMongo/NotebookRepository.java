package com.example.rdb_sem.myMongo;

//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NotebookRepository /*extends MongoRepository<Notebook,String>*/ {

    Optional<Notebook> findNotebookByDiagonal(Double diagonal);
}
