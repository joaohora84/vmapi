package com.vm.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vm.api.model.EspecialidadePrescritor;
import com.vm.api.repository.EspecialidadePrescritorRepository;

@RestController
@RequestMapping(value = "/especialidadeprescritor")
public class EspecialidadePrescritorController {

	@Autowired
	private EspecialidadePrescritorRepository especialidadePrescritorRepository;

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<EspecialidadePrescritor>> buscarTodos() {

		List<EspecialidadePrescritor> list = (List<EspecialidadePrescritor>) especialidadePrescritorRepository
				.findAll();

		return new ResponseEntity<List<EspecialidadePrescritor>>(list, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<EspecialidadePrescritor> buscarPorId(@PathVariable(value = "id") Long id) {

		Optional<EspecialidadePrescritor> especialidadePrescritor = especialidadePrescritorRepository.findById(id);

		return new ResponseEntity<EspecialidadePrescritor>(especialidadePrescritor.get(), HttpStatus.OK);

	}

	@GetMapping(value = "/pornome", produces = "application/json")
	public ResponseEntity<List<EspecialidadePrescritor>> buscarPorNome(@RequestParam("nome") String nome) {

		List<EspecialidadePrescritor> list = especialidadePrescritorRepository.getEspecialidadePorNome(nome);

		return new ResponseEntity<List<EspecialidadePrescritor>>(list, HttpStatus.OK);
	}

}
