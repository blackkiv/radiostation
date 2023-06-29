package blck.radiostation.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.temporal.ChronoUnit;

import static java.util.Objects.nonNull;

/**
 * Translation Part Type.
 *
 * @author Livio Agolini
 */
@Getter
@AllArgsConstructor
public enum TranslationPartType {

    SONG(null, null),
    INTERVIEW(BigDecimal.valueOf(30L), ChronoUnit.MINUTES),
    ADVERTISEMENT(BigDecimal.valueOf(5L), ChronoUnit.SECONDS);

    private final BigDecimal price;
    private final ChronoUnit chronoUnit;

    public boolean isPaid() {
        return nonNull(price);
    }

    public BigDecimal pricePerSecond() {
        if (!isPaid()) {
            return null;
        }
        return price.divide(
                BigDecimal.valueOf(chronoUnit.getDuration().getSeconds()),
                MathContext.UNLIMITED
        );
    }
}
