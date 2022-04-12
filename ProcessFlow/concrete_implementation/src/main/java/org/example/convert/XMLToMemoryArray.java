package org.example.convert;

import org.apache.commons.lang3.StringUtils;
import org.example.BaseFlow;
import org.example.dto.ResultDto;
import org.example.reader.XmlReaderAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLToMemoryArray implements BaseFlow {

    private String memoryArray;
    private List<List<String>> resultList;
    private final XmlReaderAdapter xmlReaderAdapter;

    public XMLToMemoryArray(XmlReaderAdapter xmlReaderAdapter) {
        this.xmlReaderAdapter = xmlReaderAdapter;
    }

    @Override
    public void setInput(String input) {
        xmlReaderAdapter.setIncludePath(input);
    }

    @Override
    public String getOutput() {
        return memoryArray;
    }

    @Override
    public void doConvert() {
        resultList = Arrays.asList(getAllResult());

        memoryArray = StringUtils.join(resultList, ";");
    }

    private List<String> getAllResult() {
        List<String> resultDtoList = new ArrayList<>();
        for (ResultDto result : xmlReaderAdapter.readValue()) {
            resultDtoList.add(result.getName() + ";" + result.getPoint());
        }
        return resultDtoList;
    }
}
