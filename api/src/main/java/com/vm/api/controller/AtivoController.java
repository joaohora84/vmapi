package com.vm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vm.api.model.Ativo;
import com.vm.api.repository.AtivoRepository;

@RestController
@RequestMapping(value = "/ativo")
public class AtivoController {

	@Autowired
	private AtivoRepository ativoRepository;

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Ativo>> ativos() {

		List<Ativo> ativos = null;

		ativos = (List<Ativo>) ativoRepository.findAll();

		return new ResponseEntity<List<Ativo>>(ativos, HttpStatus.OK);

	}

	@GetMapping(value = "/novos", produces = "application/json")
	public ResponseEntity<List<Ativo>> ativosNovos() {

		List<Ativo> ativos = null;

		ativos = ativoRepository.getAtivoNovo();

		return new ResponseEntity<List<Ativo>>(ativos, HttpStatus.OK);

	}

	@GetMapping(value = "/pesquisa", produces = "application/json")
	public ResponseEntity<List<Ativo>> ativosPorNomeEspecialidade(@RequestParam("nomepesquisa") String nomepesquisa,
			@RequestParam("especialidade") Long especialidade) {

		List<Ativo> ativos = null;

		if (especialidade != null) {

			ativos = ativoRepository.getAtivoByEspecialidadeNome(especialidade, nomepesquisa);

		} else {

			ativos = ativoRepository.getAtivoByName(nomepesquisa);

		}

		return new ResponseEntity<List<Ativo>>(ativos, HttpStatus.OK);
	}

}
