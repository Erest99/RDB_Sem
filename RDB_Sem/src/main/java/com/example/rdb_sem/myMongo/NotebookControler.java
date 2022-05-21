package com.example.rdb_sem.myMongo;

import com.mongodb.client.DistinctIterable;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/notebooks")
@AllArgsConstructor
public class NotebookControler {

    private final NotebookService notebookService;

    @Autowired
    MongoTemplate mongoTemplate;

    //namapuj všechny notebooky
    @GetMapping()
    public List<Notebook> fetchAllNotebooks()
    {
        return notebookService.getAllNotebooks();
    }

    @RequestMapping("/getString")
    public String getString()
    {
        return "Hello World";
    }

    @GetMapping("/cpu")
    public List<String> cpuOptions()
    {
        List<Notebook> l =notebookService.getAllNotebooks();
        List<String> r  = new ArrayList<>();
        for(Notebook n : l)
        {
            if( !r.contains(n.getCpu()) ) {  r.add(n.getCpu()); }

        }
        return r.stream().sorted().collect(Collectors.toList());
    }

    @GetMapping("/nonconzistent")
    public List<Notebook> nonConzistent()
    {
        List<Notebook> l =notebookService.getNonConzistent(false);
        return l;
    }

    @GetMapping("/stats")
    public List<String> statistics()
    {
        List<Notebook> k = notebookService.getAllNotebooks();
        List<Notebook> l =notebookService.getNonConzistent(false);
        List<String> r  = new ArrayList<>();
        Integer rows = k.size();
        Integer inc = l.size();
        Double data = rows * 0.510;
        r.add("Počet řádků: "+ rows);
        r.add("Počet nekonzistentních záznamů: " + inc);
        r.add("Velikost databáse: "+data+" KB");
        return r;
    }

//    @GetMapping("/nonconzistent")
//    public List<Notebook> nonConzistent()
//    {
//        List<Notebook> l =notebookService.getAllNotebooks();
//        Boolean[] ar;
//        for(Notebook n : l)
//        {
//            ar = n.getIsConsistent();
//            for(int i=0;i<18;i++) {
//                if(!ar[i])
//                {
//                    l.remove(n);
//                    break;
//                }
//            }
//
//        }
//        return l;
//    }


    @GetMapping("/cpu/{cpu}")
    public List<Notebook> processorSearch(@PathVariable String cpu) {
        if(cpu.equals("M3_kabylake"))cpu = 	"Intel Core M3(Kaby Lake / 7. generace)";
        else if(cpu.equals("M3_skylake"))cpu = "Intel Core M3(Skylake / 6. generace)";
        else if(cpu.equals("M5_skylake"))cpu = 	"Intel Core M5(Skylake / 6. generace)";
        else if(cpu.equals("M7_skylake"))cpu = 		"Intel Core M7(Skylake / 6. generace)";
        else if(cpu.equals("i3_broadwell"))cpu = 	"Intel Core i3(Broadwell / 5. generace)";
        else if(cpu.equals("i3_haswell"))cpu = 	"Intel Core i3(Haswell / 4. generace)";
        else if(cpu.equals("i3_kabylake"))cpu = 	"Intel Core i3(Kaby Lake / 7. generace) ";
        else if(cpu.equals("i3_skylake"))cpu = 	"Intel Core i3(Skylake / 6. generace)";
        else if(cpu.equals("i5_broadwell"))cpu = 	"Intel Core i5(Broadwell / 5. generace)";
        else if(cpu.equals("i5_haswell"))cpu = 		"Intel Core i5(Haswell / 4. generace)";
        else if(cpu.equals("i5_skylake"))cpu = 	"Intel Core i5(Skylake / 6. generace)";
        else if(cpu.equals("i7_broadwell"))cpu = 	"Intel Core i7(Broadwell / 5. generace)";
        else if(cpu.equals("i7_crystalwell"))cpu = 		"Intel Core i7(Crystal Well / 4. generace)";
        else if(cpu.equals("i7_haswell"))cpu = 		"Intel Core i7(Haswell / 4. generace)";
        else if(cpu.equals("i7_kabylake"))cpu = 	"Intel Core i7(Kaby Lake / 7. generace)";
        else if(cpu.equals("i7_skylake"))cpu = 	"Intel Core i7(Skylake / 6. generace)";

        return notebookService.getNbByCpu(cpu);
    }
//
//    @GetMapping("/cpu")
//    public List<Notebook> fetchUniqueCpu(){
//        return notebookService.getDistinctNotebooks();
//    }
}
