package gov.Gferias.domain.vacation_balance.repository;

import gov.Gferias.domain.usersSumary.model.UsersSumary;
import gov.Gferias.domain.vacation_balance.model.VacationBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationBalanceRepository extends JpaRepository<VacationBalance, Long> {
    boolean existsByUsersSumaryAndAccrualPeriod(UsersSumary usersSumary, Integer accrualPeriod);
}
