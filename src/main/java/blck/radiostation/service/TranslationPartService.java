package blck.radiostation.service;

import blck.radiostation.domain.entity.TranslationPart;
import blck.radiostation.repository.TranslationPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

import static blck.radiostation.util.TranslationUtil.validateTranslation;

/**
 * Translation Part Service.
 *
 * @author Livio Agolini
 */
public interface TranslationPartService extends CommonNestedService<TranslationPart> {

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class Base implements TranslationPartService {

        private final TranslationPartRepository repository;
        private final TranslationService translationService;
        private final HostService hostService;

        @Override
        @Transactional
        public void create(UUID parentId, TranslationPart entity) {
            var translation = translationService.get(parentId);
            translation.getParts().add(entity);
            validateTranslation(translation);
            entity.setHost(hostService.get(entity.getHost().getId()));
            entity.setTranslation(translation);
            repository.save(entity);
        }
    }
}
