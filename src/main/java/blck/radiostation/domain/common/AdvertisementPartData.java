package blck.radiostation.domain.common;

import blck.radiostation.domain.enums.TranslationPartType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Advertisement Part Data.
 *
 * @author Livio Agolini
 */
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class AdvertisementPartData extends AbstractTranslationPartData {

    private final String product;

    @Override
    @JsonIgnore
    public TranslationPartType getPartType() {
        return TranslationPartType.ADVERTISEMENT;
    }
}
