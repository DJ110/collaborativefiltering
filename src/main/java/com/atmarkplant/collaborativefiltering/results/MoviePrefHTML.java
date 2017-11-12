package com.atmarkplant.collaborativefiltering.results;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.BufferedWriter;
import java.io.IOException;

@Data
@EqualsAndHashCode(callSuper = false)
public class MoviePrefHTML extends HTML {

    private String[] names;

    private String[] movies;

    private double[][] sim;

    private double[][] reviews;

    private double[][] scores;

    private String[] simpersons;

    private String[] recoms;

    public MoviePrefHTML(String filename, String title) {
        super(filename, title);
    }

    @Override
    public void createStyles(BufferedWriter writer) throws IOException {
        writer.write("<style>");
        writer.write(".red{ color: red}");
        writer.write("table{ border-collapse: collapse; }");
        writer.write("</style>");
    }

    @Override
    public void createBody(BufferedWriter bufferedWriter) throws IOException{
        // Title

        // Review Data

        bufferedWriter.write("<h1>Recommendation</h1>");
        bufferedWriter.write("<table border=\"1\">");

        bufferedWriter.write("<tr>");

        bufferedWriter.write("<th>Name</th>");

        for (int i=0; i < movies.length; i++) {
            bufferedWriter.write("<th>");
            bufferedWriter.write(movies[i]);
            bufferedWriter.write("</th>");
        }
        bufferedWriter.write("<th>Similar</th>");
        bufferedWriter.write("<th>Recommendation</th>");
        bufferedWriter.write("</tr>");


        for (int i=0; i < names.length; i++) {
            bufferedWriter.write("<tr>");

            bufferedWriter.write("<td>" + names[i] + "</td>");

            for (int j=0; j < movies.length; j++) {
                if (scores[i][j] > 0) {
                    bufferedWriter.write("<td class='red'>" + String.format("%.2f", scores[i][j]) + "</td>");
                } else {
                    bufferedWriter.write("<td>" + reviews[i][j] + "</td>");
                }
               // bufferedWriter.write("<td>" + reviews[i][j] + "</td>");
            }

            bufferedWriter.write("<td>" + simpersons[i] + "</td>");
            bufferedWriter.write("<td>" + recoms[i] + "</td>");

            bufferedWriter.write("</tr>");
        }

        // Close
        bufferedWriter.write("</table>");
        bufferedWriter.write("<br>");
        bufferedWriter.write("<br>");

        //
        bufferedWriter.write("<h1>Similarity</h1>");

        bufferedWriter.write("<table border=\"1\">");
        bufferedWriter.write("<tr>");

        bufferedWriter.write("<th></th>");

        for (int i=0; i < names.length; i++) {
            bufferedWriter.write("<th>" + names[i] + "</th>");
        }
        bufferedWriter.write("</tr>");

        for (int i=0; i < names.length; i++) {
            bufferedWriter.write("<tr>");
            bufferedWriter.write("<th>" + names[i] + "</th>");
            for (int j=0; j < names.length; j++) {
                bufferedWriter.write("<td>" + String.format("%.2f", sim[i][j]) + "</td>");
            }
            bufferedWriter.write("</tr>");
        }
    }
}
