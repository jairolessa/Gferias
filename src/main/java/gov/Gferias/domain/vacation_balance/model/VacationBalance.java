package gov.Gferias.domain.vacation_balance.model;

import gov.Gferias.domain.usersSumary.model.UsersSumary;
import gov.Gferias.domain.vacation.model.Vacation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class VacationBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer accrualPeriod;

    @Column(nullable = false)
    private Integer balance;

    @OneToMany(mappedBy = "vacationBalance")
    private List<Vacation> vacations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "users_sumary", nullable = false)
    private UsersSumary usersSumary;
}
