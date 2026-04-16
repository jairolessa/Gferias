package gov.Gferias.domain.usersSumary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UsersSumary {

    @Id
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false, updatable = false)
    private String cpf;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private Boolean active;
}
