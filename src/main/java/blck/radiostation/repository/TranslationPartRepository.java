package blck.radiostation.repository;

import blck.radiostation.domain.entity.TranslationPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Translation Part Repository.
 *
 * @author Livio Agolini
 */
public interface TranslationPartRepository extends JpaRepository<TranslationPart, UUID> {
}
