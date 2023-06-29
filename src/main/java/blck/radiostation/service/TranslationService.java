package blck.radiostation.service;

import blck.radiostation.domain.dto.request.PaginationRequest;
import blck.radiostation.domain.entity.Translation;
import blck.radiostation.exception.NoDataAvailableException;
import blck.radiostation.repository.TranslationPartRepository;
import blck.radiostation.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

import static blck.radiostation.util.TranslationUtil.validateTranslation;

/**
 * Translation Service.
 *
 * @author Livio Agolini
 */
public interface TranslationService extends CommonService<Translation> {

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class Base implements TranslationService {

        private final TranslationRepository repository;
        private final TranslationPartRepository translationPartRepository;
        private final HostService hostService;

        @Override
        public Translation get(UUID id) {
            return repository.findById(id)
                    .orElseThrow(() -> new NoDataAvailableException("Translation with id [%s] not found".formatted(id)));
        }

        @Override
        public Page<Translation> getList(PaginationRequest pagination) {
            var page = PageRequest.of(pagination.getSkip(), pagination.getSize());
            return repository.findAll(page);
        }

        @Override
        @Transactional
        public UUID create(Translation translation) {
            validateTranslation(translation);
            var parts = new ArrayList<>(translation.getParts());
            translation.getParts().clear();
            var savedTranslation = repository.save(translation);

            parts.forEach(part -> {
                var host = hostService.get(part.getHost().getId());
                part.setTranslation(translation);
                part.setHost(host);
            });
            translationPartRepository.saveAll(parts);

            return savedTranslation.getId();
        }
    }
}
