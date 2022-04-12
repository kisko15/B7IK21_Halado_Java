package org.example.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.dto.ResultDto;

import java.io.*;
import java.util.List;

public class XmlReaderAdapterImpl implements XmlReaderAdapter {

    private ObjectMapper xmlMapper;
    private InputStream inputStream;
    private TypeReference<List<ResultDto>> typeReference;

    @Override
    public void setIncludePath(String path) {
        xmlMapper = new XmlMapper();
        try {
            inputStream = new FileInputStream(path);
            typeReference = new TypeReference<List<ResultDto>>() {};
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ResultDto> readValue() {
        List<ResultDto> resultList = null;
        try {
            resultList = xmlMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
