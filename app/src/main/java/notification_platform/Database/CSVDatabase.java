package notification_platform.Database;

import java.util.List;

import notification_platform.Database.MemoryManager.CSVManager;

import java.util.HashMap;

import java.io.File;
import java.io.IOException;

public class CSVDatabase implements Database {

    private HashMap<String, Table> tables;
    private final static String FOLDER_NAME = "data/";

    public CSVDatabase() throws DatabaseException {
        this.createTables();
    }

    private void createTables() throws DatabaseException {
        File dir = new File(FOLDER_NAME);
        File[] directoryListing = dir.listFiles();

        if (directoryListing != null){
            for (File child : directoryListing){

                Table table = new Table(child.getName(), new CSVManager(FOLDER_NAME + child.getName()));
                tables.put(child.getName(), table);
            }
        }
    }

    public List<Row> getRows(String table){
        return this.tables.get(table).getRows();
    };

    public int addRows(List<Row> rows, String table) throws CsvDatabaseException {
        try {
            this.tables.get(table).addRows(rows);
            return 1;
        } catch (Exception e){
            throw new CsvDatabaseException(e.getMessage());
        }
    }

    public List<Row> getRows(HashMap<String, String> conditions, String table){
        return this.tables.get(table).getRows(conditions);
    };

    public void flushRows(String table) {

        try {
            this.tables.get(table).flushRows();
        } catch (IOException i) {

        }
    }
}; 


