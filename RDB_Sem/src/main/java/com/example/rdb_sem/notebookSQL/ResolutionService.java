package com.example.rdb_sem.notebookSQL;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResolutionService {


     private final ResolutionRepository resolutionRepository;

     @Autowired
     public ResolutionService(ResolutionRepository resolutionRepository) {
          this.resolutionRepository = resolutionRepository;
     }

}