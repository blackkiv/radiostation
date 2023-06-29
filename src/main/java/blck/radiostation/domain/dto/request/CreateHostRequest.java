package blck.radiostation.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

/**
 * Create Host Request.
 *
 * @author Livio Agolini
 */
public record CreateHostRequest(@NotEmpty String name,
                                @NotEmpty String cv,
                                LocalDate startingDay,
                                boolean invited) {
}
