package gov.Gferias.domain.vacation.repository;

import gov.Gferias.domain.vacation.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
