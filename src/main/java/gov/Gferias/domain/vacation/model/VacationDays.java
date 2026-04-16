package gov.Gferias.domain.vacation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VacationDays {
    THIRTY(30),
    TWENTY(20),
    FIFTEEN(15),
    TEN(10);

    private final int value;
}
