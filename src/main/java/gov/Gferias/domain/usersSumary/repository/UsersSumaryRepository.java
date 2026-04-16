package gov.Gferias.domain.usersSumary.repository;

import gov.Gferias.domain.usersSumary.model.UsersSumary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersSumaryRepository extends JpaRepository<UsersSumary, Long> {
}
