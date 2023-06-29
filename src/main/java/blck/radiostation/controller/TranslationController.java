package blck.radiostation.controller;

import blck.radiostation.domain.dto.TranslationDto;
import blck.radiostation.domain.dto.TranslationListDto;
import blck.radiostation.domain.dto.request.CreateTranslationRequest;
import blck.radiostation.domain.dto.request.PaginationRequest;
import blck.radiostation.mapper.TranslationMapper;
import blck.radiostation.service.TranslationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static blck.radiostation.domain.enums.TranslationPartDisplayTab.TRANSLATION;
import static blck.radiostation.util.ControllerUtil.getListHeaders;

/**
 * Translation Controller.
 *
 * @author Livio Agolini
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.V1 + "/translations")
public class TranslationController {

    private final TranslationService service;
    private final TranslationMapper mapper;

    @GetMapping
    public ResponseEntity<List<TranslationListDto>> getTranslations(@ParameterObject PaginationRequest pagination) {
        var translationPage = service.getList(pagination);

        return ResponseEntity.ok()
                .headers(getListHeaders(
                        translationPage.getTotalElements(),
                        pagination.getSkip(), pagination.getSize()
                ))
                .body(mapper.toTranslationListDtos(translationPage.getContent()));
    }

    @GetMapping("/{id}")
    public TranslationDto getTranslation(@PathVariable @NotNull UUID id) {
        return mapper.toTranslationDto(service.get(id), TRANSLATION);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createTranslation(@RequestBody @NotNull @Valid CreateTranslationRequest request) {
        return service.create(mapper.toTranslation(request));
    }
}
