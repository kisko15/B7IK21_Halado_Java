package org.example.reader;

import org.example.dto.ResultDto;

import java.util.List;

public interface XmlReaderAdapter {
    void setIncludePath(String path);
    List<ResultDto> readValue();
}
