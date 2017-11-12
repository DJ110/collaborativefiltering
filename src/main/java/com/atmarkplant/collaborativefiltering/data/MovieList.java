package com.atmarkplant.collaborativefiltering.data;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Data
public class MovieList {

    private List<String> movielist = new ArrayList<String>();

    private String filename;  // "src/main/resources/"

    public MovieList(String filename) {
        this.filename = filename;
    }

    public void read() {
        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream(filename);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while((line = reader.readLine()) != null) {
                movielist.add(line);
            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public int getMovieListSize() {
        return movielist.size();
    }

    public String[] getMovieListArray() {
        return movielist.toArray(new String[movielist.size()]);
    }
}
