package blck.radiostation.domain.dto;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Translation List Dto.
 *
 * @author Livio Agolini
 */
public record TranslationListDto(UUID id, BigInteger duration, int parts) {
}
