package com.Bridgelabz;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    public static final String Sample_CSV_File_Path = "E:\\Fellowship\\annotation\\src\\main\\java\\users.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException{
        try (Writer writer = Files.newBufferedWriter(Paths.get(Sample_CSV_File_Path));) {
            StatefulBeanToCsv<MyUser> beanToCsv = new StatefulBeanToCsvBuilder<MyUser>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<MyUser> myUsers = new ArrayList<>();
            myUsers.add(new MyUser("Saurabh Dagwar", "dagwarsaurabh@gmail.com", "123457788", "India"));
            myUsers.add(new MyUser("Shubham manik", "shubhammanik@gmail.com", "986543455", "UK"));
            beanToCsv.write(myUsers);
        } catch (Exception e) {
                e.printStackTrace();
        }

    }
}