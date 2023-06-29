package blck.radiostation.mapper;

import blck.radiostation.domain.dto.HostDto;
import blck.radiostation.domain.dto.HostFullDto;
import blck.radiostation.domain.dto.request.CreateHostRequest;
import blck.radiostation.domain.entity.Host;
import blck.radiostation.domain.enums.TranslationPartDisplayTab;
import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Host Mapper.
 *
 * @author Livio Agolini
 */
@Mapper(
        componentModel = ComponentModel.SPRING,
        uses = {TranslationPartMapper.class},
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface HostMapper {

    @Mapping(target = "experience", source = "startingDay", qualifiedByName = "hostExperience")
    HostDto toHostDto(Host source);

    List<HostDto> toHostDtos(Collection<Host> source);

    @Mapping(target = "experience", source = "startingDay", qualifiedByName = "hostExperience")
    HostFullDto toHostFullDto(Host source, @Context TranslationPartDisplayTab displayTab);

    Host toHost(CreateHostRequest source);

    @Named("hostExperience")
    default Long hostExperience(LocalDate startingDay) {
        return LocalDate.now().toEpochDay() - startingDay.toEpochDay();
    }
}
