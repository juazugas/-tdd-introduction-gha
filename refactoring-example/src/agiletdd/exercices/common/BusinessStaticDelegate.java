package agiletdd.exercices.common;

import java.util.List;

/**
 * Class create for substitute the static declarations of methods in BusinessStatic
 *
 */
public class BusinessStaticDelegate {

    public String getConnectionUri() {
        return BusinessStatic.getConnectionUri();
    }

    public List<String> findAllEntities(String connection, int page, int size) {
        return BusinessStatic.findAllEntities(connection, page, size);
    }

}
