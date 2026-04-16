package gov.Gferias.domain.change_vacation.model;

import gov.Gferias.domain.vacation.model.Vacation;
import gov.Gferias.domain.vacation_change_status.model.ChangeVacationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class ChangeVacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ChangeType changeType;

    private String justify;

    @Column(nullable = false)
    private LocalDateTime requestDate;

    @ManyToOne
    @JoinColumn
    private Vacation vacation;

    @OneToMany(mappedBy = "changeVacation")
    private List<ChangeVacationStatus> changeVacationStatuses;
}
