package com.indracompany.treinamento.model.service;

import org.springframework.stereotype.Service;

import com.indracompany.treinamento.model.entity.ContaBancaria;
import com.indracompany.treinamento.model.entity.ExtratoBancario;
import com.indracompany.treinamento.model.repository.ExtratoBancarioRepository;

@Service
public class ExtratoBancarioService extends GenericCrudService<ExtratoBancario, Long, ExtratoBancarioRepository >{
	
	public void atualizarExtrato (String relatorio, double valor, ContaBancaria contaOrigem, String data) {
		ExtratoBancario extrato = new ExtratoBancario();		
		extrato.setContaBancariaOrigem(contaOrigem);		
		extrato.setRelatorio(relatorio);
		extrato.setValor(valor);
		extrato.setData(data);
		super.salvar(extrato);		
	}
	
	
}
