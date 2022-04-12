package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.convert.CSVToXML;
import org.example.convert.XMLToMemoryArray;
import org.example.reader.CsvReaderAdapterImpl;
import org.example.reader.XmlReaderAdapterImpl;

import java.io.IOException;

public class BaseRunner {

    public static void main(String args[]) throws IOException {
        BaseFlow csvToXML = new CSVToXML(new CsvReaderAdapterImpl(), new XmlMapper());
        csvToXML.setInput("data.csv");
        csvToXML.doConvert();

        BaseFlow xmlToMemoryArray = new XMLToMemoryArray(new XmlReaderAdapterImpl());
        xmlToMemoryArray.setInput(csvToXML.getOutput());
        xmlToMemoryArray.doConvert();
        System.out.println(xmlToMemoryArray.getOutput());

    }
}
