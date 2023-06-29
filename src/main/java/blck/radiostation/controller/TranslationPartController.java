package blck.radiostation.controller;

import blck.radiostation.domain.dto.request.CreateTranslationPartRequest;
import blck.radiostation.mapper.TranslationPartMapper;
import blck.radiostation.service.TranslationPartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Translation Part Controller.
 *
 * @author Livio Agolini
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.V1 + "/translations/{translationId}/parts")
public class TranslationPartController {

    private final TranslationPartService service;
    private final TranslationPartMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTranslationPart(@PathVariable @NotNull UUID translationId,
                                      @RequestBody @NotNull @Valid CreateTranslationPartRequest request) {
        service.create(
                translationId,
                mapper.toTranslationPart(request)
        );
    }
}
