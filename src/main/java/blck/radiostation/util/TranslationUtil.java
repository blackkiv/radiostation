package blck.radiostation.util;

import blck.radiostation.domain.entity.Translation;
import blck.radiostation.domain.entity.TranslationPart;
import blck.radiostation.exception.InvalidEntityException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Translation Util.
 *
 * @author Livio Agolini
 */
public record TranslationUtil() {

    public static void validateTranslation(Translation translation) {
        var parts = translation.getParts();
        var validPartsOrder = parts.stream()
                .map(TranslationPart::getTranslationOrder)
                .distinct().count() == parts.size();
        if (!validPartsOrder) {
            throw new InvalidEntityException("Translation", "invalid parts order");
        }

        var greaterThan = 1;
        var validPartsDuration = parts.stream()
                .map(TranslationPart::getDuration)
                .reduce(BigInteger::add)
                .orElse(BigInteger.ZERO)
                .compareTo(translation.getDuration()) != greaterThan;
        if (!validPartsDuration) {
            throw new InvalidEntityException("Translation", "parts duration cannot be greater than translation duration");
        }

        var validPaidContentDuration = parts.stream()
                .filter(part -> part.getType().isPaid())
                .map(TranslationPart::getDuration)
                .reduce(BigInteger::add)
                .orElse(BigInteger.ZERO)
                .compareTo(translation.getDuration().divide(BigInteger.TWO)) != greaterThan;
        if (!validPaidContentDuration) {
            throw new InvalidEntityException("Translation", "paid content duration cannot be more than 50% of the translation duration");
        }
    }

    public static BigDecimal calculateTranslationIncome(Translation translation) {
        return translation.getParts().stream()
                .filter(part -> part.getType().isPaid())
                .reduce(BigDecimal.ZERO, (subtotal, part) -> {
                    var type = part.getType();
                    var partIncome = Objects.requireNonNull(type.pricePerSecond())
                            .multiply(new BigDecimal(part.getDuration()));
                    return subtotal.add(partIncome);
                }, BigDecimal::add);

    }
}
