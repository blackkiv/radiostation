package blck.radiostation.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Pagination Request.
 *
 * @author Livio Agolini
 */
@Getter
@AllArgsConstructor
public class PaginationRequest {

    private final int skip = 0;
    private final int size = 100;
}
