package com.example.rdb_sem;

import com.example.rdb_sem.myMongo.Notebook;
import com.example.rdb_sem.myMongo.NotebookRepository;
import com.example.rdb_sem.myMongo.NotebookService;
import com.example.rdb_sem.notebookSQL.*;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;


import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import java.io.FileNotFoundException;


@SpringBootApplication
public class RdbSemApplication {

    private final String[] colors = {"red","white","black","silver","grey"};
    private final String[] resolutions = {"1920 x 1080","1280 x 800", "1366 x 768","3200 x 1800", "3840 x 2160", "2560 x 1440"};


    public static void main(String[] args) throws FileNotFoundException {
//        List< Product> neco = DB.readCSV("src/main/java/com/example/rdb_sem/notebookSQL/export1651501890.csv");
        SpringApplication.run(RdbSemApplication.class, args);

    }

    @Bean
    @DependsOn({"bimport"})
    CommandLineRunner commandLineRunnerSQL(ProductRepository productRepository, ColorRepository colorRepository, ResolutionRepository resolutionRepository)
    {
        Color color = new Color("grey");
        Resolution resolution = new Resolution("1920 x 1080");
        return args -> {
        Product testProduct = new Product("9TZNF",15.0f,resolution,"Full HD", color,300,300,300,2,"some processor",6,3.7f,"some memory",20,"SSD",2000,"GTX2060",null,"00000000000000000");
            //Product testProduct = new Product(productRepository.getByProdId("9TZNF"));
            if(productRepository.existsByProdId(testProduct.getProdId())&&
                    productRepository.existsByCoreCount(testProduct.getCoreCount())&&
                    productRepository.existsByDepth(testProduct.getDepth())&&
                    productRepository.existsByDiagonal(testProduct.getDiagonal())&&
                    productRepository.existsByGpuType(testProduct.getGpuType())&&
                    productRepository.existsByHddSize(testProduct.getHddSize())&&
                    productRepository.existsByHddType(testProduct.getHddType())&&
                    productRepository.existsByHeight(testProduct.getHeight())&&
                    productRepository.existsByMemorySize(testProduct.getMemorySize())&&
                    productRepository.existsByMemoryType(testProduct.getMemoryType())&&
                    productRepository.existsByOs(testProduct.getOs())&&
                    productRepository.existsByProcessorFreq(testProduct.getProcessorFreq())&&
                    productRepository.existsByProcessorType(testProduct.getProcessorType())&&
                    productRepository.existsByResWord(testProduct.getResWord())&&
                    productRepository.existsByWeight(testProduct.getWeight())&&
                    productRepository.existsByWidth(testProduct.getWidth())&&
                    productRepository.existsByResolution(testProduct.getResolution())&&
                    productRepository.existsByColor(testProduct.getColor())
            )
            {
                System.out.println("Duplikátní záznam pro: "+testProduct+" ,neimportuji");
            }
            else if(productRepository.existsByProdId(testProduct.getProdId()))
            {
                System.out.println("WARNING: " +testProduct + "is already in database");
                String consistency = checkResolutionConsistencyString(testProduct.getResolution().toString(),testProduct.getResWord());
                List<Product> kandidates = productRepository.findAllByProdId(testProduct.getProdId());
                String isConsistent = isConsistentString(consistency,testProduct,kandidates,productRepository);
                testProduct.setIsConsistent(isConsistent);
                productRepository.save(testProduct);
            }
            else if(!colorRepository.existsByColor(testProduct.getColor().toString()))
            {
                System.out.println("color of "+testProduct+" is not available");
            }
            else if(!resolutionRepository.existsByResolution(testProduct.getResolution().toString()))
            {
                System.out.println("resolution of "+testProduct+" is not available");
            }
            else
            {
                productRepository.save(testProduct);
            }
        };
    }
    @Bean
    CommandLineRunner runner(NotebookRepository repository, MongoTemplate mongoTemplate)
    {
        return args -> {

            JSONParser parser = new JSONParser();
            try
            {
                Object obj = parser.parse(new FileReader("src/main/resources/json/import.json"));
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray data = (JSONArray) jsonObject.get("data");


                for(int i = 0; i< data.size();i++)
                {
                    JSONObject nb = (JSONObject) data.get(i);
                    String serial = (String) nb.get("serial");
                    Double screen = Double.valueOf((String) nb.get("screen"));
                    String resolution = (String) nb.get("resolution");
                    String resolutionCode = (String) nb.get("resolution_code");
                    String cpu = (String) nb.get("cpu");
                    Integer cores = Integer.valueOf((String) nb.get("cores"));
                    String ram = (String) nb.get("ram");
                    Double cpuFreq = Double.valueOf((String) nb.get("cpu_freq"));
                    Integer ramCapacity = Integer.valueOf((String) nb.get("ram_capacity"));
                    String os = (String) nb.get("os");
                    Integer hdd = Integer.valueOf((String) nb.get("hdd"));
                    String hddType = (String) nb.get("hdd_type");
                    String gpu = (String) nb.get("gpu");
                    String color = (String) nb.get("color");
                    Integer height = Integer.valueOf((String) nb.get("height"));
                    Integer width = Integer.valueOf((String) nb.get("width"));
                    Integer depth = Integer.valueOf((String) nb.get("depth"));
                    Integer weight = Integer.valueOf((String) nb.get("weight"));
                    Boolean[] isConsistent = checkResolutionConsistency(resolution,resolutionCode);
                    Notebook notebook = new Notebook(serial,screen,resolution,resolutionCode,cpu,cores,cpuFreq,ram,ramCapacity,os,hdd,hddType,gpu,color,height,width,depth,weight,isConsistent);

                    Boolean pass = true;
                    if( Arrays.stream(colors).anyMatch(color::equals));
                        else {System.out.println("No such collor available for " + notebook);pass = false;}
                    if( Arrays.stream(resolutions).anyMatch(resolution::equals));
                        else {System.out.println("No such resolution available for " + notebook);pass = false;}
                    if(pass)usingMongoTemplateAndQuery(repository, mongoTemplate, serial, notebook);
                }

            }
            catch(FileNotFoundException e) {e.printStackTrace();}
            catch(IOException e) {e.printStackTrace();}
            catch(ParseException e) {e.printStackTrace();}
            catch(Exception e) {e.printStackTrace();}

        };

    }

    private void usingMongoTemplateAndQuery(NotebookRepository repository, MongoTemplate mongoTemplate, String serial, Notebook notebook) {
        Query query = new Query();
        query.addCriteria(Criteria.where("serial").is(serial));
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("serial").is(serial));
        query1.addCriteria(Criteria.where("screen").is(notebook.getScreen()));
        query1.addCriteria(Criteria.where("resolution").is(notebook.getResolution()));
        query1.addCriteria(Criteria.where("resolution_code").is(notebook.getResolution_code()));
        query1.addCriteria(Criteria.where("cpu").is(notebook.getCpu()));
        query1.addCriteria(Criteria.where("cores").is(notebook.getCores()));
        query1.addCriteria(Criteria.where("cpu_freq").is(notebook.getCpu_freq()));
        query1.addCriteria(Criteria.where("ram").is(notebook.getRam()));
        query1.addCriteria(Criteria.where("ram_capacity").is(notebook.getRam_capacity()));
        query1.addCriteria(Criteria.where("os").is(notebook.getOs()));
        query1.addCriteria(Criteria.where("hdd").is(notebook.getHdd()));
        query1.addCriteria(Criteria.where("hdd_type").is(notebook.getHdd_type()));
        query1.addCriteria(Criteria.where("gpu").is(notebook.getGpu()));
        query1.addCriteria(Criteria.where("color").is(notebook.getColor()));
        query1.addCriteria(Criteria.where("height").is(notebook.getHeight()));
        query1.addCriteria(Criteria.where("width").is(notebook.getWidth()));
        query1.addCriteria(Criteria.where("depth").is(notebook.getDepth()));
        query1.addCriteria(Criteria.where("weight").is(notebook.getWeight()));


        List<Notebook> notebooks = mongoTemplate.find(query1,Notebook.class);
        if(notebooks.size()>0)
        {
            System.out.println("Duplicate record for: "+notebook);
        }
        else {
            notebooks = mongoTemplate.find(query,Notebook.class);
            if (notebooks.isEmpty()) {
                System.out.println("Inserting product " + notebook);
                repository.insert(notebook);
            } else {
                System.out.println(("WARNING: " + notebook + " is already in database, inconsistent record"));
                //notebook.setIsConsistent(2);
                boolean result = true;
                for (Notebook n : notebooks) {
                    for(int i =0;i<18;i++)
                    {
                        if(!n.getIsConsistent()[i])result = false;
                    }
                    if(result)
                    {
                        Boolean[] myArray = new Boolean[18];
                        if(notebook.getSerial().equals(n.getSerial()))myArray[0]=false;
                        else myArray[0]=true;
                        if(notebook.getScreen().equals(n.getScreen()))myArray[1]=true;
                        else myArray[1]=false;
                        if(notebook.getResolution().equals(n.getResolution()))myArray[2]=true;
                        else myArray[2]=false;
                        if(notebook.getCpu().equals(n.getCpu()))myArray[4]=true;
                        else myArray[4]=false;
                        if(notebook.getCores().equals(n.getCores()))myArray[5]=true;
                        else myArray[5]=false;
                        if(notebook.getCpu_freq().equals(n.getCpu_freq()))myArray[6]=true;
                        else myArray[6]=false;
                        if(notebook.getRam().equals(n.getRam()))myArray[7]=true;
                        else myArray[7]=false;
                        if(notebook.getRam_capacity().equals(n.getRam_capacity()))myArray[8]=true;
                        else myArray[8]=false;
                        if(notebook.getOs().equals(n.getOs()))myArray[9]=true;
                        else myArray[9]=false;
                        if(notebook.getHdd().equals(n.getHdd()))myArray[10]=true;
                        else myArray[10]=false;
                        if(notebook.getHdd_type().equals(n.getHdd_type()))myArray[11]=true;
                        else myArray[11]=false;
                        if(notebook.getGpu().equals(n.getGpu()))myArray[12]=true;
                        else myArray[12]=false;
                        if(notebook.getColor().equals(n.getColor()))myArray[13]=true;
                        else myArray[13]=false;
                        if(notebook.getHeight().equals(n.getHeight()))myArray[14]=true;
                        else myArray[14]=false;
                        if(notebook.getWidth().equals(n.getWidth()))myArray[15]=true;
                        else myArray[15]=false;
                        if(notebook.getDepth().equals(n.getDepth()))myArray[16]=true;
                        else myArray[16]=false;
                        if(notebook.getWeight().equals(n.getWeight()))myArray[17]=true;
                        else myArray[17]=false;
                        notebook.setIsConsistent(myArray);
                        break;
                    }
                }
                repository.insert(notebook);
            }
        }
    }

    private Boolean[] checkResolutionConsistency(String resolution,String res_word)
    {
        Boolean[] value = new Boolean[18];
        for(int i =0;i<18;i++)value[i]=true;
        if(resolution.equals("1920 x 1080")  && res_word.equals("Full HD")){value[3] = true;}
        else if(resolution.equals("1366 x 768") && res_word.equals("HD")){value[3] = true;}
        else if(resolution.equals("1280 x 800") && res_word.equals("WXGA")){value[3] = true;}
        else if(resolution.equals("2560 x 1440") && res_word.equals("WQHD")){value[3] = true;}
        else if(resolution.equals("3200 x 1800") && res_word.equals("QHD +")){value[3] = true;}
        else if(resolution.equals("3840 x 2160") && res_word.equals("UHD 4K0")){value[3] = true;}
        else value[3] = false;

        return value;
    }

    private String isConsistentString(String consistency,Product product,List<Product> ps, ProductRepository repository) {
        StringBuilder value = null;
        for (Product p : ps) {
            value= new StringBuilder(consistency);


            if (value.charAt(0)=='0') {

                if(product.getOs()==null)product.setOs("no OS");
                if(p.getOs()==null)p.setOs("no OS");

                if (product.getProdId().equals(p.getProdId())) value.setCharAt(0, '1');
                else value.setCharAt(0, '0');
                if (product.getDiagonal().equals(p.getDiagonal())) value.setCharAt(1, '0');
                else value.setCharAt(1, '1');
                if (product.getResolution().equals(p.getResolution())) value.setCharAt(2, '0');
                else value.setCharAt(2, '1');
                if (product.getProcessorType().equals(p.getProcessorType()))value.setCharAt(4, '0');
                else value.setCharAt(4, '1');
                if (product.getCoreCount().equals(p.getCoreCount())) value.setCharAt(5, '0');
                else value.setCharAt(5, '1');
                if (product.getProcessorFreq().equals(p.getProcessorFreq())) value.setCharAt(6, '0');
                else value.setCharAt(6, '1');
                if (product.getMemoryType().equals(p.getMemoryType())) value.setCharAt(7, '0');
                else value.setCharAt(7, '1');
                if (product.getMemorySize().equals(p.getMemorySize())) value.setCharAt(8, '0');
                else value.setCharAt(8, '1');
                if (product.getOs().equals(p.getOs())) value.setCharAt(9, '0');
                else value.setCharAt(9, '1');
                if (product.getHddSize().equals(p.getHddSize())) value.setCharAt(10, '0');
                else value.setCharAt(10, '1');
                if (product.getHddType().equals(p.getHddType())) value.setCharAt(11, '0');
                else value.setCharAt(11, '1');
                if (product.getGpuType().equals(p.getGpuType())) value.setCharAt(12, '0');
                else value.setCharAt(12, '1');
                if (product.getColor().equals(p.getColor())) value.setCharAt(13, '0');
                else value.setCharAt(13, '1');
                if (product.getHeight().equals(p.getHeight())) value.setCharAt(14, '0');
                else value.setCharAt(14, '1');
                if (product.getWidth().equals(p.getWidth())) value.setCharAt(15, '0');
                else value.setCharAt(15, '1');
                if (product.getDepth().equals(p.getDepth())) value.setCharAt(16, '0');
                else value.setCharAt(16, '1');
                if (product.getWeight().equals(p.getWeight())) value.setCharAt(17, '0');
                else value.setCharAt(17, '1');

                break;
            }
        }
        return value.toString();
    }

    private String checkResolutionConsistencyString(String resolution,String res_word)
    {
        StringBuilder value = new StringBuilder("000000000000000000");
        if(resolution.equals("1920 x 1080")  && res_word.equals("Full HD"))value.setCharAt(3, '0');
        else if(resolution.equals("1366 x 768") && res_word.equals("HD"))value.setCharAt(3, '0');
        else if(resolution.equals("1280 x 800") && res_word.equals("WXGA"))value.setCharAt(3, '0');
        else if(resolution.equals("2560 x 1440") && res_word.equals("WQHD"))value.setCharAt(3, '0');
        else if(resolution.equals("3200 x 1800") && res_word.equals("QHD +"))value.setCharAt(3, '0');
        else if(resolution.equals("3840 x 2160") && res_word.equals("UHD 4K0"))value.setCharAt(3, '0');
        else value.setCharAt(3, '1');

        return value.toString();
    }





}
