package com.Bridgelabz;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CSVAndGSONTester {
    private static final String Sample_CSV_File_Path = "E:\\Fellowship\\annotation\\src\\main\\java\\users.csv";
    private static final String Sample_JSON_File_Path = "E:\\Fellowship\\annotation\\src\\main\\java\\users.json";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(Sample_CSV_File_Path));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(Sample_JSON_File_Path);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(Sample_JSON_File_Path));
            CSVUser[] userObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(userObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

