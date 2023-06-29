package blck.radiostation.domain.entity;

import blck.radiostation.domain.common.AbstractTranslationPartData;
import blck.radiostation.domain.enums.TranslationPartType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Translation Part.
 *
 * @author Livio Agolini
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TranslationPart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Translation translation;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Host host;

    @Column(nullable = false, updatable = false)
    @Enumerated(value = EnumType.STRING)
    private TranslationPartType type;

    @Column(nullable = false)
    private BigInteger duration; // duration in seconds

    @Column(nullable = false)
    private Integer translationOrder;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false)
    private AbstractTranslationPartData data;
}
