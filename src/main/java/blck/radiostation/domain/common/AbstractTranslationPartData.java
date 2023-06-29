package blck.radiostation.domain.common;

import blck.radiostation.domain.enums.TranslationPartType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Abstract Translation Part Data.
 *
 * @author Livio Agolini
 */
@JsonTypeInfo(use = Id.NAME, property = "part_type")
@JsonSubTypes({
        @Type(value = SongPartData.class, name = "SONG"),
        @Type(value = InterviewPartData.class, name = "INTERVIEW"),
        @Type(value = AdvertisementPartData.class, name = "ADVERTISEMENT"),
})
public abstract class AbstractTranslationPartData {

    @JsonIgnore
    public abstract TranslationPartType getPartType();
}
