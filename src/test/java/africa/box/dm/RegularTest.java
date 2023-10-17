package africa.box.dm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import static   org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RegularTest {
    private final Logger Log = LoggerFactory.getLogger(RegularTest.class);

    private Map<String, Object> regularDataModel;

    //private Map<String, Object> data = new HashMap<>();

    @Before
    public void setup() throws Exception{
        File file = new ClassPathResource("regular.json").getFile();

        regularDataModel = new ObjectMapper().readValue(file, HashMap.class);
    }

    public void loadData(){


        Map<String, Object> data = new HashMap<>();

        addEntry(data, "ProcessingFinished", regularDataModel.get("ProcessingFinished"));

        Map<String, Object> ContainerList = new HashMap<>();
        //addEntry(ContainerList, "Count", );
    }


    public void addEntry(Map<String, Object>map, String key, Object value){
        if (!map.containsKey(key)){
            map.put(key, value);
        }
    }



    public void findEntry(Map<String, Object> map,
                                               String key, Map<String, Object> data){
        Map.Entry<String, Object> entryFOund = null;
        for (Map.Entry<String, Object> entry: map.entrySet()){
            if (entry.getKey().equals(key)){
                entryFOund = entry;

                if(!data.containsKey(key))
                    data.put(key, entryFOund.getValue());
                break;
                //return data;
            }else{
                if (entry.getValue() instanceof HashMap){
                    findEntry((HashMap<String, Object>) entry.getValue(), key, data);
                    if (entryFOund != null)
                        break;

                }else if (entry.getValue() != null && entry.getValue().getClass().isArray()){
                    List<Map<String, Object>> list = Arrays.asList((HashMap[])entry.getValue());
                    for (Map<String, Object> item:list){
                        findEntry(item, key, data);
                        if (entryFOund != null)
                            break;
                    }
                }else if (entry.getValue() instanceof Collection){
                    List<Map<String, Object>> list = (ArrayList)entry.getValue();
                    for (Object item:list){

                        if (item instanceof HashMap){
                            findEntry((HashMap) item, key, data);
                            if (entryFOund != null)
                                break;
                        }

                    }
                }
            }


        }
      //  System.out.println("END CALL");
       // return data;
    }




    public void  findEntryByValue(Map<String, Object> map,
                                               String key, Map<String, Object> data){
        //System.out.println("New CALL");
        Map.Entry<String, Object> entryFOund = null;
        Map<String, Object> parent = map;
        for (Map.Entry<String, Object> entry: map.entrySet()){

            if (entry.getValue() != null) {
                if ( entry.getValue().equals(key)){
                    entryFOund = entry;
                    if (!data.containsKey(key) || data.get(key) == null) {
                        data.put(key,  parent.get("Buf_Text"));
                        System.out.println(entryFOund);
                        System.out.println(parent.get("Buf_Text"));
                        //return data;
                    }

//               Log.info("Value : {}", parent.get("Buf_Text"));
//                Log.info("Retrieved Key");
                    break;
                }else{
                    if (entry.getValue() instanceof HashMap){
                        parent = (HashMap)  entry.getValue();

                        findEntryByValue((HashMap<String, Object>) entry.getValue(), key, data);

                    }else if (entry.getValue().getClass().isArray()){
                        List<Map<String, Object>> list = Arrays.asList((HashMap[])entry.getValue());
                        for (Map<String, Object> item:list){
                            findEntryByValue(item, key, data);
                        }
                    }else if (entry.getValue() instanceof Collection){
                        //System.out.println(entry.getValue());
                        List<Object> list = (ArrayList)entry.getValue();
                        for (Object item:list){
                            if (item instanceof HashMap) {
                                findEntryByValue((HashMap) item, key, data);
                            }
                        }
                    }
                }
            }


        }
        //System.out.println("END CALL");
        //return data;
    }



    @Test
    public void search(){
        //Map.Entry<String, Object> result =  findEntry(regularDataModel, "List");
        System.out.println(regularDataModel);
        Map<String, Object> result = new HashMap<>();
        findEntryByValue(regularDataModel, "Surname", result);
        findEntryByValue(regularDataModel, "Document Number", result);
        findEntryByValue(regularDataModel, "Given Names", result);
        findEntryByValue(regularDataModel, "Date of Birth", result);
        findEntryByValue(regularDataModel, "Place of Birth", result);
        findEntryByValue(regularDataModel, "Date of Expiry", result);
        findEntryByValue(regularDataModel, "Date of Issue", result);
        findEntryByValue(regularDataModel, "Place of Issue", result);
        findEntry(regularDataModel,"result_type", result);
        findEntry(regularDataModel,"Status", result);
        //assertThat(data.entrySet().size()).isEqualTo(10);
        System.out.println(result);
    }
}
