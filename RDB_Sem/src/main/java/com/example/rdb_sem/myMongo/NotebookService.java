package com.example.rdb_sem.myMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

//@AllArgsConstructor
@Service
public class NotebookService {

    @Autowired
    MongoTemplate mongoTemplate;

    private final NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    //vrátí všechny položky db
    public List<Notebook> getAllNotebooks() {
            return notebookRepository.findAll();
    }

    public List<Notebook> getNbByCpu(String cpu){return notebookRepository.findNotebookByCpu(cpu);}

    public List<Notebook> getNonConzistent(Boolean b){return notebookRepository.findAllByIsConsistentIsContaining(b);}

//    public List<Notebook> getDistinctNotebooks()
//    {
//        List <Notebook> list = notebookRepository.findAll();
//        List <Notebook> result= Collections.<Notebook>emptyList();
//        for(Notebook n : list)
//        {
//            if( !result.contains(n) ) { result.add(n); }
//        }
//        return result;
//    }
//
//    public List<Notebook> findNotebookByProc(String cpu){return  notebookRepository.findNotebookByCpu(cpu);}
//
//
//    public Iterable<Notebook> list() {
//        return notebookRepository.findAll();
//    }
//
//    public Notebook save(Notebook notebook) {
//        return notebookRepository.save(notebook);
//    }
//
//    public void save(List<Notebook> notebooks) {
//        notebookRepository.saveAll(notebooks);
//    }
}
