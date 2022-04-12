package org.example.reader;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderAdapterImpl implements CsvReaderAdapter {

    private CSVReader csvReader;

    @Override
    public String[] readNext() throws IOException {
        return csvReader.readNext();
    }

    @Override
    public void setIncludePath(String path) {
        try {
            csvReader = new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
