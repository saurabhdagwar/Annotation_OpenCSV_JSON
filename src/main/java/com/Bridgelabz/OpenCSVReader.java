package com.Bridgelabz;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    public static final String Sample_CSV_File_Path = "E:\\Fellowship\\annotation\\src\\main\\java\\users.csv";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(Sample_CSV_File_Path));
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                System.out.println("===================================");
                System.out.println("Name : " + record[0]);
                System.out.println("Email : " + record[1]);
                System.out.println("Mobile : " + record[2]);
                System.out.println("Country : " + record[3]);
                System.out.println("===================================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


