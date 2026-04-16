package gov.Gferias.features.vacationRequest;

import gov.Gferias.domain.vacation.model.VacationDays;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacationRequestDto {

    private LocalDate startDate;
    private VacationDays days;
    private Long vacationBalanceId;
}
