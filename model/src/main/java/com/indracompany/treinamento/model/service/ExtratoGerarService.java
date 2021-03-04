package com.indracompany.treinamento.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indracompany.treinamento.exception.AplicacaoException;
import com.indracompany.treinamento.exception.ExceptionValidacoes;
import com.indracompany.treinamento.model.entity.ExtratoBancario;
import com.indracompany.treinamento.model.repository.ContaBancariaExtratoRepository;

@Service
public class ExtratoGerarService extends GenericCrudService<ExtratoBancario, Long, ContaBancariaExtratoRepository> {

	public void salvarMovimentacao(String agencia, String conta, String movimentacao) {

		ExtratoBancario operacao = new ExtratoBancario();

		operacao.setMovimentacao(movimentacao);
		operacao.setAgencia(agencia);
		operacao.setConta(conta);
		operacao.setData(new Date());

		super.salvar(operacao);

	}

	public List<ExtratoBancario> mostraExtratoData(String agencia, String conta) {

		List<ExtratoBancario> operacao = repository.findByAgenciaAndConta(agencia, conta, null, null);

		if (operacao == null) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_CONTA_INVALIDA);
		}

		return operacao; 
	}
	
	public List<ExtratoBancario> mostraExtrato(String agencia, String conta, Date inicio, Date fim) {

		List<ExtratoBancario> operacao = repository.ExtratoData(agencia, conta, inicio, fim);

		if (operacao == null) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_CONTA_INVALIDA);
		}

		return operacao; 
	}
}