package blck.radiostation.mapper;

import blck.radiostation.domain.dto.TranslationPartDto;
import blck.radiostation.domain.dto.request.CreateTranslationPartRequest;
import blck.radiostation.domain.entity.TranslationPart;
import blck.radiostation.domain.enums.TranslationPartDisplayTab;
import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

import java.util.Collection;
import java.util.List;

/**
 * Translation Part Mapper.
 *
 * @author Livio Agolini
 */
@Mapper(
        componentModel = ComponentModel.SPRING,
        uses = {HostMapper.class},
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TranslationPartMapper {

    @Mapping(target = "order", source = "translationOrder")
    @Mapping(target = "host", conditionExpression = "java(displayTab.name() == \"TRANSLATION\")")
    @Mapping(target = "translationId", source = "translation.id", conditionExpression = "java(displayTab.name() == \"HOST\")")
    TranslationPartDto toTranslationPartDto(TranslationPart source, @Context TranslationPartDisplayTab displayTab);

    List<TranslationPartDto> toTranslationPartDtos(Collection<TranslationPart> source, @Context TranslationPartDisplayTab displayTab);

    @Mapping(target = "host.id", source = "host")
    TranslationPart toTranslationPart(CreateTranslationPartRequest source);

    List<TranslationPart> toTranslationParts(Collection<CreateTranslationPartRequest> source);
}
