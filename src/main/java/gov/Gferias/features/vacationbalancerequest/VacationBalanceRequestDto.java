package gov.Gferias.features.vacationbalancerequest;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VacationBalanceRequestDto {

    @NotNull(message = "Informe o período aquisitivo")
    private Integer accrualPeriod;
    private Integer balance;
    private Long userSumaryId;
}
