package com.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin293/Desktop/OpenCSV/src/main/resources/Sample.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<POJOFile> csvToBean = new CsvToBeanBuilder<POJOFile>(reader)
                    .withType(POJOFile.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<POJOFile> pojoFileIterator = csvToBean.iterator();
            while (pojoFileIterator.hasNext()) {
                POJOFile pojoFile = pojoFileIterator.next();
                System.out.println("NAME : " + pojoFile.getName());
                System.out.println("EMAIL : " + pojoFile.getEmail());
                System.out.println("PHONE : " + pojoFile.getPhoneNo());
                System.out.println("COUNTRY : " + pojoFile.getCountry());
                System.out.println("-----------------------------------");

            }
        }
    }
}
