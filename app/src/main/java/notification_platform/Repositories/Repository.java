package notification_platform.Repositories;

import java.util.List;

import notification_platform.Entities.Entity;

public interface Repository {

    List<Entity> getItems();

    List<Entity> getItems(String attr, String val);
}
