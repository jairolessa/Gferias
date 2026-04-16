package gov.Gferias.features.vacationbalancerequest;

import gov.Gferias.domain.vacation_balance.repository.VacationBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VacationBalanceRequestService {

    private final VacationBalanceRepository vacationBalanceRepository;

    public void saveVacationBalance(VacationBalanceRequestDto dto){


    }
}
