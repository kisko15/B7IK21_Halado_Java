package org.example.reader;

import java.io.IOException;

public interface CsvReaderAdapter {
    String[] readNext() throws IOException;
    void setIncludePath(String path);
}
