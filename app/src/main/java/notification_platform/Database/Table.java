package notification_platform.Database;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import notification_platform.Database.MemoryManager.FileManager;

public class Table {
    
    private final String entityType;
    private List<Row> tableRows;
    private HashMap<String, Integer> headers;
    private FileManager fileManager;

    public Table(String entityType, FileManager fileManager) throws DatabaseException{
        this.entityType = entityType;
        this.fileManager = fileManager;
    };

    private int getAndIncrementId(){
        return 1;
    };

    private HashMap<Integer, String> getConditionsIdx(HashMap<String, String> conditions){
        HashMap<Integer, String> conditionsIdx = new HashMap<Integer, String>();

        for (String key : conditions.keySet()){
            Integer idx = headers.get(key);
            conditionsIdx.put(idx, conditions.get(key));
        }

        return conditionsIdx;
    }
    
    public List<Row> getRows(){
        if (tableRows.isEmpty()){
            fileManager.read();
        }

        return this.tableRows;
    };

    public List<Row> getRows(HashMap<String, String> conditions){
        List<Row> rows = List.of();
        HashMap<Integer, String> conditionsIdx = getConditionsIdx(conditions);

        for (Row row : this.tableRows) {
            String[] rowValue = row.getValue();

            for (Integer idx : conditionsIdx.keySet()){
                if (!rowValue[idx].equals(conditionsIdx.get(idx).toString())){
                    continue;
                }

            rows.add(row);
            }
        }
        return rows;
    };

    public int addRows(List<Row> rows) throws CsvDatabaseException {
        try {
            this.getAndIncrementId();
            this.tableRows.addAll(rows);
            return 1;
        } catch (Exception e){
            throw new CsvDatabaseException(e.getMessage());
        }
    };

    public void flushRows() throws IOException{
        List<String[]> rows = List.of();

        for (Row row : this.tableRows){
            rows.add(row.getValue());
        }
        
        this.fileManager.write(rows);
    }

    public String getEntityType(){
        return this.entityType;
    }
}