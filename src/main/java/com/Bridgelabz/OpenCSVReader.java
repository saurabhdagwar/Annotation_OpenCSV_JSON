package com.Bridgelabz;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

    public class OpenCSVReader {
        public static final String Sample_CSV_File_Path = "E:\\Fellowship\\annotation\\src\\main\\java\\users.csv";

        public static void main(String[] args) {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(Sample_CSV_File_Path));
                String[] nextRecord;
                CSVReader csvReader = new CSVReader(reader);
                while ((nextRecord = csvReader.readNext()) != null) {
                    System.out.println("===================================");
                    System.out.println("Name : " + nextRecord[0]);
                    System.out.println("Email : " + nextRecord[1]);
                    System.out.println("Mobile : " + nextRecord[2]);
                    System.out.println("Country : " + nextRecord[3]);
                    System.out.println("===================================");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


