package blck.radiostation.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Host.
 *
 * @author Livio Agolini
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private String cv;

    private LocalDate startingDay;

    @Column(nullable = false)
    private Boolean invited = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "host", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TranslationPart> parts;
}
