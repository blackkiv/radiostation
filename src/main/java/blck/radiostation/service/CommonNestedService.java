package blck.radiostation.service;

import java.util.UUID;

/**
 * Common Nested Service.
 *
 * @author Livio Agolini
 */
public interface CommonNestedService<T> {

    void create(UUID parentId, T entity);
}
