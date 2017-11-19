package com.atmarkplant.collaborativefiltering.results;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

abstract public class HTML {

    private String filename;

    private String title;

    public HTML(String filename, String title) {
        this.filename = filename;
        this.title = title;
    }

    public void createHTML() {

        FileOutputStream fout = null;
        BufferedWriter writer = null;

        try {
            fout = new FileOutputStream(filename);
            writer = new BufferedWriter(new OutputStreamWriter(fout));

            createHeader(writer, title);
            createBodyStart(writer, title);

            // Create Contents
            createBody(writer);

            createEnd(writer);

        } catch (IOException e) {

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void createStyles(BufferedWriter writer) throws IOException {
        writer.write("<styles>");
        writer.write("</styles>");
    }

    abstract public void createBody(BufferedWriter writer) throws IOException;

    private void createHeader(BufferedWriter writer, String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        createStyles(writer);
        writer.write("</head>");
    }

    private void createBodyStart(BufferedWriter writer, String title) throws IOException {
        writer.write("<body>");
        writer.write("<h1>" + title + "</h1>");
    }

    private void createEnd(BufferedWriter writer) throws IOException {
        writer.write("</body>");
        writer.write("</html>");
    }
}
