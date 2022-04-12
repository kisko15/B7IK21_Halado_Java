package org.example.convert;

import org.example.dto.ResultDto;
import org.example.reader.XmlReaderAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class XMLToMemoryArrayTest {

    @Mock
    private XmlReaderAdapter readerAdapter;

    @InjectMocks
    private XMLToMemoryArray xmlToMemoryArray;

    @Test
    public void doConvert() throws IOException {
        //GIVEN
        List<ResultDto> resultDto = new ArrayList<>();
        when(readerAdapter.readValue()).thenReturn(resultDto);

        //WHEN
        xmlToMemoryArray.doConvert();

        //THEN
        verify(readerAdapter, times(1)).readValue();
    }

}