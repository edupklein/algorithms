package com.example.filereader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader {
    
    public static void main(String[] args) {
        
        String fileName = "src/main/resources/hotels.json";
        JsonReader jr = new JsonReader();

        try{
            JsonArray array = jr.hotelFromJsonFile(fileName);
            for(JsonElement je: array) {
                if(je.isJsonObject()) {
                    
                    JsonObject hotel = je.getAsJsonObject();
                    
                    
                    if(hotel.get("rating").getAsFloat() > 7.0) {
                        System.out.println(hotel.get("name").getAsString());
                    }
                }
            }
        }catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public JsonArray hotelFromJsonFile(String fileName) throws RuntimeException, FileNotFoundException, IOException {
        
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)) {

            JsonElement tree = JsonParser.parseReader(reader);

            JsonArray array = tree.getAsJsonArray();
            
            return array;
        }
    }
    
}

/**
 * Estudar:
- tipos diferentes de System Design
- diferença entre inner join e left join

- diferença entre triggers, procedures

- injeção de dependência

 */
