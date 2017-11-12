package com.atmarkplant.collaborativefiltering.data;

import lombok.Data;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class MovieReview {

    Map<String, Map<String, Double>> reviews = new HashMap<String, Map<String, Double>>();

    private String filename;  // "src/main/resources/"

    public MovieReview(String filename) {
        this.filename = filename;
    }

    public void read() {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filename);
            JsonReader reader = Json.createReader(fis);
            JsonObject root = reader.readObject();
            JsonObject members = root.getJsonObject("data");

            for (String name : members.keySet()) {
                JsonObject reviewsjson = members.getJsonObject(name);
                Map<String, Double> reviewset = new HashMap<String, Double>();
                for (String key : reviewsjson.keySet()) {
                    String value = reviewsjson.getString(key);
                    reviewset.put(key, Double.parseDouble(value));
                }
                reviews.put(name, reviewset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getReviewMemberSize() {
        return reviews.size();
    }
}
