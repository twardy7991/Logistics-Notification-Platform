package notification_platform.Repositories;

import java.util.ArrayList;
import java.util.List;

import notification_platform.Entities.*;
import notification_platform.Database.*;

abstract class AbstractRepository implements Repository {

    private Database database;

    public AbstractRepository(Database database){
        this.database = database;
    };

    @Override
    public List<Entity> getItems(){
        List<Row> rows = database.getRows("table");
        List<Entity> entities = new ArrayList<>();
        
        for (Row row : rows){
            entities.add(this.rowToEntity(row));
        }

        return entities;
    };

    @Override
    public List<Entity> getItems(String attr, String val){
        List<Row> rows = database.getRows("value");
        List<Entity> entities = new ArrayList<>();
        
        for (Row row : rows){
            entities.add(this.rowToEntity(row));
        }

        return entities;
    };

    protected abstract Entity rowToEntity(Row row);

    protected abstract Row entityToRow(Entity entity);
}

