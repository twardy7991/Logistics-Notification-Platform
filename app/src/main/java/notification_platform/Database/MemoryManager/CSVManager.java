package notification_platform.Database.MemoryManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.nio.file.Files;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CSVManager implements FileManager{

    private CSVReader csvReader; 
    private CSVWriter csvWriter;
    private String filePath;

    public CSVManager(String filePath){
        this.filePath = filePath;
        this.createFileReader(filePath);
        this.createFileWriter(filePath);
    };

    //for testing
    public CSVManager(CSVReader reader, CSVWriter writer) {
        this.csvReader = reader;
        this.csvWriter = writer;
    };

    private void createFileWriter(String filePath){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
        } catch (FileNotFoundException e) {

            try {
                File file = new File(filePath);
                fileWriter = new FileWriter(file);
                } catch (FileNotFoundException f) {
                    //throw new CsvDatabaseException("Could not open the file");
                } catch (IOException a ){}
        } catch (IOException i ) {}

        this.csvWriter = new CSVWriter(fileWriter);
    }

    private void createFileReader(String filePath){
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {

            try {
                File file = new File(filePath);
                fileReader = new FileReader(file);
                } catch (FileNotFoundException f) {
                    //throw new CsvDatabaseException("Could not open the file");
                }
        }

        this.csvReader = new CSVReader(fileReader); 
    }

    public List<String[]> read(){
        String[] nextRecord;
        List<String[]> records = List.of();

        try {   
            while ((nextRecord = this.csvReader.readNext()) != null){
                records.add(nextRecord);
            }
        } catch (IOException i) {

        } catch (CsvValidationException c) {

        };
        return records;
    }

    public void write(List<String[]> records){
        try {
            Files.newBufferedWriter(Paths.get(this.filePath), StandardOpenOption.TRUNCATE_EXISTING);
            this.csvWriter.writeAll(records);
        } catch (IOException  i) {

        }
    }
}
