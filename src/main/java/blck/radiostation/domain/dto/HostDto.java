package blck.radiostation.domain.dto;

import java.util.UUID;

/**
 * Host Dto.
 *
 * @author Livio Agolini
 */
public record HostDto(UUID id,
                      String name,
                      Long experience,
                      boolean invited) {
}
