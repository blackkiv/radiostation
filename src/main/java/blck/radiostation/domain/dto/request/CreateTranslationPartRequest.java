package blck.radiostation.domain.dto.request;

import blck.radiostation.domain.common.AbstractTranslationPartData;
import blck.radiostation.domain.enums.TranslationPartType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Create Translation Part Request.
 *
 * @author Livio Agolini
 */
public record CreateTranslationPartRequest(@NotNull TranslationPartType type,
                                           @NotNull UUID host,
                                           @Positive BigInteger duration,
                                           @Positive Integer translationOrder,
                                           AbstractTranslationPartData data) {
}
