package notification_platform.Database;

abstract class DatabaseException extends Exception{
    public DatabaseException(String reason){
        super(reason);
    }
}
