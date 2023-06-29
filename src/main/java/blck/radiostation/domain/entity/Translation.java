package blck.radiostation.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Translation.
 *
 * @author Livio Agolini
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigInteger duration; // duration in seconds

    @JsonManagedReference
    @OrderBy("translationOrder")
    @OneToMany(mappedBy = "translation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TranslationPart> parts;

    public Translation(UUID id) {
        this.id = id;
    }
}
