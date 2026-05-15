package notification_platform.Repositories;

import notification_platform.Database.*;
import notification_platform.Entities.Client;
import notification_platform.Entities.Entity;


public class ClientRepository extends AbstractRepository{

    public ClientRepository(Database database){
        super(database);
    }

    @Override
    protected Entity rowToEntity(Row row){
        return new Client();
    }

    @Override
    public Row entityToRow(Entity entity){
        Row row = new CSVRow(new String[]{ "Apple", "Banana", "Orange" });
        return row;
    };
}