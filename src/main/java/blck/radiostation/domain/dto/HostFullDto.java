package blck.radiostation.domain.dto;

import java.util.List;
import java.util.UUID;

/**
 * Host Full Dto.
 *
 * @author Livio Agolini
 */
public record HostFullDto(UUID id,
                          String name,
                          String cv,
                          Long experience,
                          boolean invited,
                          List<TranslationPartDto> parts) {
}
