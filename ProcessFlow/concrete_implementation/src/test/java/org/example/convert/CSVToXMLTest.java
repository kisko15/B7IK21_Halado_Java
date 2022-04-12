package org.example.convert;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.reader.CsvReaderAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CSVToXMLTest {

    @Mock
    private XmlMapper xmlMapper;

    @Mock
    private CsvReaderAdapter csvReaderAdapter;

    @InjectMocks
    private CSVToXML csvToXML;

    @Test
    public void doConvert() throws IOException {
        //GIVEN
        when(csvReaderAdapter.readNext()).thenReturn(new String[] { "Valami", "1.0" }).thenReturn(null);

        //WHEN
        csvToXML.doConvert();

        //THEN
        verify(csvReaderAdapter, times(2)).readNext();
        verify(xmlMapper, times(1)).writeValue(any(File.class), any());
    }

}