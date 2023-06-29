package blck.radiostation.service;

import blck.radiostation.domain.dto.request.PaginationRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * Common Service.
 *
 * @author Livio Agolini
 */
public interface CommonService<T> {

    T get(UUID id);

    Page<T> getList(PaginationRequest pagination);

    UUID create(T entity);
}
