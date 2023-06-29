package blck.radiostation.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigInteger;
import java.util.List;

/**
 * Create Translation Request.
 *
 * @author Livio Agolini
 */
public record CreateTranslationRequest(@Positive BigInteger duration,
                                       @NotNull List<@Valid CreateTranslationPartRequest> parts) {
}
