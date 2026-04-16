package gov.Gferias.features.vacationbalancerequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/vacation-balance")
public class VacationBalanceRequestController {

    private final VacationBalanceRequestService vacationBalanceRequestService;

    @PostMapping
    public ResponseEntity<String> registerVacationBalance(@RequestBody @Valid VacationBalanceRequestDto vacationBalanceRequestDto){

        vacationBalanceRequestService.saveVacationBalance(vacationBalanceRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Período aquisitivo cadastrado com sucesso!");
    }
}
