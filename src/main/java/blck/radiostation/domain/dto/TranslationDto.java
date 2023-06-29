package blck.radiostation.domain.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Translation Dto.
 *
 * @author Livio Agolini
 */
public record TranslationDto(UUID id,
                             BigInteger duration,
                             BigDecimal translationIncome,
                             List<TranslationPartDto> parts) {

}
