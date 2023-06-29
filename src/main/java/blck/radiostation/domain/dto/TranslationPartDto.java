package blck.radiostation.domain.dto;

import blck.radiostation.domain.common.AbstractTranslationPartData;
import blck.radiostation.domain.enums.TranslationPartType;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Translation Part Dto.
 *
 * @author Livio Agolini
 */
public record TranslationPartDto(UUID id,
                                 UUID translationId,
                                 HostDto host,
                                 TranslationPartType type,
                                 BigInteger duration,
                                 Integer order,
                                 AbstractTranslationPartData data) {

}
