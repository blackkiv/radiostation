package blck.radiostation.domain.common;

import blck.radiostation.domain.enums.TranslationPartType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Song Part Data.
 *
 * @author Livio Agolini
 */
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class SongPartData extends AbstractTranslationPartData {

    private final String performer;
    private final String song;

    @Override
    @JsonIgnore
    public TranslationPartType getPartType() {
        return TranslationPartType.SONG;
    }
}
