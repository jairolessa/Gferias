package gov.Gferias.domain.change_vacation.repository;

import gov.Gferias.domain.change_vacation.model.ChangeVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ChangeVacantionRepository extends JpaRepository<ChangeVacation, Long> {
}
