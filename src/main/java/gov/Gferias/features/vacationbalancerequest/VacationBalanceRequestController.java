package gov.Gferias.features.vacationbalancerequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/vacatioon-balance")
public class VacationBalanceRequestController {

    private final VacationBalanceRequestService vacationBalanceRequestService;

    @PostMapping
    public void registerVacationBalance(@RequestBody @Valid VacationBalanceRequestDto vacationBalanceRequestDto){

        vacationBalanceRequestService.saveVacationBalance(vacationBalanceRequestDto);
    }
}
