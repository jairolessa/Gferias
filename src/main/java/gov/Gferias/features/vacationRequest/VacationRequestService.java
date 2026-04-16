package gov.Gferias.features.vacationRequest;

import gov.Gferias.domain.vacation.model.Vacation;
import gov.Gferias.domain.vacation.repository.VacationRepository;
import gov.Gferias.domain.vacation_balance.model.VacationBalance;
import gov.Gferias.domain.vacation_balance.repository.VacationBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class VacationRequestService {

    private final VacationRepository vacationRepository;
    private final VacationBalanceRepository vacationBalanceRepository;

    @Transactional
    public void registerVacation(VacationRequestDto dto) {

        // 1. Buscar saldo
        VacationBalance vacationBalance = vacationBalanceRepository.findById(dto.getVacationBalanceId())
                .orElseThrow(() -> new IllegalArgumentException("Saldo de férias não encontrado"));

        // 3. Validar saldo
        if (vacationBalance.getBalance() < dto.getDays().getValue()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        // 4. Calcular data final
        LocalDate endDate = dto.getStartDate().plusDays(dto.getDays().getValue() - 1);

        // 5. Criar entidade
        Vacation vacation = new Vacation();
        vacation.setStartDate(dto.getStartDate());
        vacation.setEndDate(endDate);
        vacation.setDays(dto.getDays());
        vacation.setVacationBalance(vacationBalance);

        // 6. Atualizar saldo
        vacationBalance.setBalance(vacationBalance.getBalance() - dto.getDays().getValue());

        // 7. Salvar
        vacationRepository.save(vacation);
        vacationBalanceRepository.save(vacationBalance);

    }

}
