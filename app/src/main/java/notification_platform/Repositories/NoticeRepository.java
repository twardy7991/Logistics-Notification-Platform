package notification_platform.Repositories;

import notification_platform.Database.CSVRow;
import notification_platform.Database.Database;
import notification_platform.Database.Row;
import notification_platform.Entities.*;

public class NoticeRepository extends AbstractRepository{

    public NoticeRepository(Database database){
        super(database);
    }

    @Override
    protected Entity rowToEntity(Row row){
        Notice notice = new Notice();

        

        return new Notice();
    }

    @Override
    public Row entityToRow(Entity entity){
        Row row = new CSVRow(new String[]{ "Apple", "Banana", "Orange" });
        return row;
    };
}
