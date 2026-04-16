package gov.Gferias.features.vacationRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/vacation")
public class VacationRequestController {

    private final VacationRequestService vacationRequestService;

    @PostMapping
    public ResponseEntity<String> registerVacation(@RequestBody @Valid VacationRequestDto dto){
        vacationRequestService.registerVacation(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso!");
    }
}
