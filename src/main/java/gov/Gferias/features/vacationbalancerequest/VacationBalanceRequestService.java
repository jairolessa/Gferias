package gov.Gferias.features.vacationbalancerequest;

import gov.Gferias.domain.usersSumary.model.UsersSumary;
import gov.Gferias.domain.usersSumary.repository.UsersSumaryRepository;
import gov.Gferias.domain.vacation_balance.model.VacationBalance;
import gov.Gferias.domain.vacation_balance.repository.VacationBalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VacationBalanceRequestService {

    private final VacationBalanceRepository vacationBalanceRepository;
    private final UsersSumaryRepository usersSumaryRepository;

    public void saveVacationBalance(VacationBalanceRequestDto dto){

        // 1. Buscar usuário sincronizado
        UsersSumary usersSumary = usersSumaryRepository.findById(dto.getUserSumaryId())
                .orElseThrow(() -> new IllegalStateException("Usuário não sincronizado na base de férias"));

        // 2. Validar se já existe saldo para o período aquisitivo
        boolean alreadyExists = vacationBalanceRepository
                .existsByUsersSumaryAndAccrualPeriod(usersSumary, dto.getAccrualPeriod());

        if (alreadyExists) {
            throw new IllegalArgumentException("Saldo já cadastrado para esse período aquisitivo");
        }

        // 3. Criar saldo
        VacationBalance vacationBalance = new VacationBalance();
        vacationBalance.setAccrualPeriod(dto.getAccrualPeriod());
        vacationBalance.setBalance(30); // regra padrão (pode evoluir depois)
        vacationBalance.setUsersSumary(usersSumary);

        // 4. Persistir
        vacationBalanceRepository.save(vacationBalance);
    }
}
