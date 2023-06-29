package blck.radiostation.repository;

import blck.radiostation.domain.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Host Repository.
 *
 * @author Livio Agolini
 */
public interface HostRepository extends JpaRepository<Host, UUID> {
}
