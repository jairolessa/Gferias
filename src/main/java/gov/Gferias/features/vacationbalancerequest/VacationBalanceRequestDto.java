package gov.Gferias.features.vacationbalancerequest;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VacationBalanceRequestDto {

    @NotNull(message = "Informe o período aquisitivo")
    private Integer accrualPeriod;
    private Integer balance;
    private List<Long> vacationsId = new ArrayList<>();
    private Long publicServer;
}
