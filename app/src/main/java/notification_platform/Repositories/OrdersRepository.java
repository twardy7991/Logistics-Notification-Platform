package notification_platform.Repositories;

import notification_platform.Database.*;
import notification_platform.Entities.Entity;
import notification_platform.Entities.Order;

public class OrdersRepository extends AbstractRepository{

    public OrdersRepository(Database database){
        super(database);
    }

    @Override
    protected Entity rowToEntity(Row row){
        return new Order();
    }

        @Override
    public Row entityToRow(Entity entity){
        Row row = new CSVRow(new String[]{ "Apple", "Banana", "Orange" });
        return row;
    };
}
