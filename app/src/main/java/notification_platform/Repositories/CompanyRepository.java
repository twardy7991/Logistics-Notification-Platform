package notification_platform.Repositories;

import notification_platform.Database.*;
import notification_platform.Entities.*;

public class CompanyRepository extends AbstractRepository{
    
    public CompanyRepository(Database database){
        super(database);
    }

    @Override
    protected Entity rowToEntity(Row row){
        return new Company();
    }

        @Override
    public Row entityToRow(Entity entity){
        Row row = new CSVRow(new String[]{ "Apple", "Banana", "Orange" });
        return row;
    };
}