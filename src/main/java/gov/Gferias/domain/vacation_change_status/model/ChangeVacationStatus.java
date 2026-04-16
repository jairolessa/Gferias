package gov.Gferias.domain.vacation_change_status.model;

import gov.Gferias.domain.change_vacation.model.ChangeVacation;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ChangeVacationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusChengeType statusChengeType;

    @Column(nullable = false)
    private LocalDateTime changeStatusDate;

    @ManyToOne
    @JoinColumn
    private ChangeVacation changeVacation;
}
