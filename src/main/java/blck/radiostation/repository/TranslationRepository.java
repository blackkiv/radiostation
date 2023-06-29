package blck.radiostation.repository;

import blck.radiostation.domain.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Translation Repository.
 *
 * @author Livio Agolini
 */
public interface TranslationRepository extends JpaRepository<Translation, UUID> {

}
