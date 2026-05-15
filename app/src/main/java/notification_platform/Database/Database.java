package notification_platform.Database;

import java.util.List;
import java.util.HashMap;

public interface Database {
    
    public List<Row> getRows(String table);

    public List<Row> getRows(HashMap<String, String> conditions, String table);

    public int addRows(List<Row> rows, String table) throws CsvDatabaseException; 
}
