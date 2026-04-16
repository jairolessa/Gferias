package gov.Gferias.domain.vacation.model;

import gov.Gferias.domain.change_vacation.model.ChangeVacation;
import gov.Gferias.domain.vacation_balance.model.VacationBalance;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private VacationDays days;

    @ManyToOne
    private VacationBalance vacationBalance;

    @OneToMany(mappedBy = "vacation")
    private List<ChangeVacation> changeVacations = new ArrayList<>();
}
