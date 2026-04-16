package gov.Gferias.domain.vacation_change_status.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusChengeType {
    PENDING ("PENDENTE"),
    DENIED ("NEGADO"),
    APPROVED ("APROVADO");

    private String statusChangeType;
}
