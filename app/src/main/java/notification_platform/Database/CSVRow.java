package notification_platform.Database;

public class CSVRow implements Row  {
    private String[] value;

    public CSVRow(String[] value){
        this.value = value;
    } 

    public String[] getValue(){
        return this.value;
    }
}
