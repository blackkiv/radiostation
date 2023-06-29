package blck.radiostation.controller;

import blck.radiostation.domain.dto.HostDto;
import blck.radiostation.domain.dto.HostFullDto;
import blck.radiostation.domain.dto.request.CreateHostRequest;
import blck.radiostation.domain.dto.request.PaginationRequest;
import blck.radiostation.domain.enums.TranslationPartDisplayTab;
import blck.radiostation.mapper.HostMapper;
import blck.radiostation.service.HostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static blck.radiostation.domain.enums.TranslationPartDisplayTab.HOST;
import static blck.radiostation.util.ControllerUtil.getListHeaders;

/**
 * Host Controller.
 *
 * @author Livio Agolini
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.V1 + "/hosts")
public class HostController {

    private final HostService service;
    private final HostMapper mapper;

    @GetMapping
    public ResponseEntity<List<HostDto>> getHosts(@ParameterObject PaginationRequest pagination) {
        var hostsPage = service.getList(pagination);

        return ResponseEntity.ok()
                .headers(getListHeaders(
                        hostsPage.getTotalElements(),
                        pagination.getSkip(), pagination.getSize()
                ))
                .body(mapper.toHostDtos(hostsPage.getContent()));
    }

    @GetMapping("/{id}")
    public HostFullDto getHost(@PathVariable UUID id) {
        return mapper.toHostFullDto(service.get(id), HOST);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createHost(@RequestBody @NotNull @Valid CreateHostRequest request) {
        return service.create(mapper.toHost(request));
    }
}
