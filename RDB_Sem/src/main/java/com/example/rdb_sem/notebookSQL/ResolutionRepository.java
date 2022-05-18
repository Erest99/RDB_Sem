package com.example.rdb_sem.notebookSQL;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolutionRepository extends JpaRepository<Resolution,Long> {
    //DynamicType.Builder.RecordComponentDefinition.Optional<Product> findProductByNameAndState(String id);

}