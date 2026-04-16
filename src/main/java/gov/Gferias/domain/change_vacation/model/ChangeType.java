package gov.Gferias.domain.change_vacation.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ChangeType {
    PERSONAL_INTEREST ("Interesse Particular"),
    SERVICE_INTEREST ("Interesse do Serviço");

    private String changeType;
}
