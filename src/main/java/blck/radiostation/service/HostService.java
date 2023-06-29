package blck.radiostation.service;

import blck.radiostation.domain.dto.request.PaginationRequest;
import blck.radiostation.domain.entity.Host;
import blck.radiostation.exception.InvalidEntityException;
import blck.radiostation.exception.NoDataAvailableException;
import blck.radiostation.repository.HostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static blck.radiostation.util.JsonUtil.validJson;
import static java.util.Objects.nonNull;

/**
 * Host Service.
 *
 * @author Livio Agolini
 */
public interface HostService extends CommonService<Host> {

    @Service
    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    class Base implements HostService {

        private final HostRepository repository;

        @Override
        public Host get(UUID id) {
            return repository.findById(id)
                    .orElseThrow(() -> new NoDataAvailableException("Host with id [%s] not found".formatted(id)));
        }

        @Override
        public Page<Host> getList(PaginationRequest pagination) {
            var page = PageRequest.of(pagination.getSkip(), pagination.getSize());
            return repository.findAll(page);
        }

        @Override
        @Transactional
        public UUID create(Host entity) {
            validateHost(entity);
            return repository.save(entity).getId();
        }

        private void validateHost(Host host) {
            var validStartingDay = host.getInvited() || nonNull(host.getStartingDay());
            if (!validStartingDay) {
                throw new InvalidEntityException("Host", "not invited host should have starting day");
            }

            var validCv = validJson(host.getCv());
            if (!validCv) {
                throw new InvalidEntityException("Host", "invalid host cv");
            }
        }
    }
}
