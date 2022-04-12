package org.example.convert;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.example.BaseFlow;
import org.example.dto.Result;
import org.example.reader.CsvReaderAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToXML implements BaseFlow {

    private String inputFilePath;
    private final String xmlFilePath = "data.xml";
    private final CsvReaderAdapter csvReaderAdapter;
    private final XmlMapper xmlMapper;

    public CSVToXML(CsvReaderAdapter csvReaderAdapter, XmlMapper xmlMapper) {
        this.csvReaderAdapter = csvReaderAdapter;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void setInput(String input) {
        this.inputFilePath = input;
        csvReaderAdapter.setIncludePath(inputFilePath);
    }

    @Override
    public String getOutput() {
        return xmlFilePath;
    }

    @Override
    public void doConvert() {
        try {
            List<Result> allResult = getAllResult();
            xmlMapper.writeValue(new File(xmlFilePath), allResult);
        } catch (IOException e) {
            throw new RuntimeException("Error during serializing object", e);
        }
    }

    private List<Result> getAllResult() throws IOException {
        List<Result> outputResult = new ArrayList<>();
        String[] values;
        while ((values = csvReaderAdapter.readNext()) != null) {
            outputResult.add(new Result(values[0], Double.parseDouble(values[1])));
        }

        return outputResult;
    }

}
