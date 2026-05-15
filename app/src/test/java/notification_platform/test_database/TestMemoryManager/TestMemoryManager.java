package notification_platform.test_database.TestMemoryManager;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import notification_platform.Database.CSVDatabase;

public class TestMemoryManager {

    CSVReader mockReader = Mockito.mock(CSVReader.class);
    CSVWriter mockWriter = Mockito.mock(CSVWriter.class);

    when(mockReader.readNext()).thenReturn(new String[]{"Apple", "Banana", "Orange"});

}
