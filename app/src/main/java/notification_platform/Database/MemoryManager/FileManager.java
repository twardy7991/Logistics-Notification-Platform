package notification_platform.Database.MemoryManager;

import java.util.List;

public interface FileManager {
    public void write(List<String[]> records);

    public List<String[]> read();
}
