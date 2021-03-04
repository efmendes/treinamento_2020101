package com.indracompany.treinamento.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indracompany.treinamento.model.dto.OperacaoExtratoDTO;
import com.indracompany.treinamento.model.entity.ExtratoBancario;
import com.indracompany.treinamento.model.service.ExtratoGerarService;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("rest/extratoBancario")
public class OperacaoExtratoRest extends GenericCrudRest<ExtratoBancario, Long, ExtratoGerarService> {
	
	@RequestMapping(value = "/gerar-extrato-data/{agencia}/{conta}/{inicio}/{fim}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<List<ExtratoBancario>> gerarExtratoData(final OperacaoExtratoDTO dto) {
		List<ExtratoBancario> operacao = getService().mostraExtrato(dto.getAgencia(), dto.getConta(), dto.getInicio(),
				dto.getFim());
		return new ResponseEntity<>(operacao, HttpStatus.OK);
	}
}