package com.indracompany.treinamento.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepositoDTO extends GenericDTO {

	private static final long serialVersionUID = 1L;

	private String agencia;

	private String numeroConta;

	private double valor;
}