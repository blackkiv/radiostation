package blck.radiostation.mapper;

import blck.radiostation.domain.dto.TranslationDto;
import blck.radiostation.domain.dto.TranslationListDto;
import blck.radiostation.domain.dto.request.CreateTranslationRequest;
import blck.radiostation.domain.entity.Translation;
import blck.radiostation.domain.entity.TranslationPart;
import blck.radiostation.domain.enums.TranslationPartDisplayTab;
import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static blck.radiostation.util.TranslationUtil.calculateTranslationIncome;

/**
 * Translation Mapper.
 *
 * @author Livio Agolini
 */
@Mapper(componentModel = ComponentModel.SPRING, uses = {TranslationPartMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TranslationMapper {

    @Mapping(target = "parts", source = "parts", qualifiedByName = "partsCount")
    TranslationListDto toTranslationListDto(Translation source);

    List<TranslationListDto> toTranslationListDtos(Collection<Translation> source);

    @Mapping(target = "translationIncome", source = "source", qualifiedByName = "translationIncome")
    TranslationDto toTranslationDto(Translation source, @Context TranslationPartDisplayTab displayTab);

    Translation toTranslation(CreateTranslationRequest source);

    @Named(value = "partsCount")
    default int partsCount(List<TranslationPart> parts) {
        return parts.size();
    }

    @Named(value = "translationIncome")
    default BigDecimal translationIncome(Translation translation) {
        return calculateTranslationIncome(translation);
    }
}
