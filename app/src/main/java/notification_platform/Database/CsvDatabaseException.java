package notification_platform.Database;

public class CsvDatabaseException extends DatabaseException {
    public CsvDatabaseException(String reason) {
        super("CSVDatabaseError: " + reason);
    }
}
