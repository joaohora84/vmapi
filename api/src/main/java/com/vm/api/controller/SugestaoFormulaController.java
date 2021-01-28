package com.vm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vm.api.model.SugestaoFormula;
import com.vm.api.repository.SugestaoFormulaRepository;

@RestController
@RequestMapping(value = "/sugestaoformula")
public class SugestaoFormulaController {

	@Autowired
	private SugestaoFormulaRepository sugestaoFormulaRespository;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<SugestaoFormula>> sugestaoFormulaPorAtivo() {

		List<SugestaoFormula> list = sugestaoFormulaRespository.findAll();

		return new ResponseEntity<List<SugestaoFormula>>(list, HttpStatus.OK);

	}
	
	@GetMapping(value = "/idativo", produces = "application/json")
	public ResponseEntity<List<SugestaoFormula>> sugestaoFormulaPorAtivo(@RequestParam("idativo") Long idativo) {

		List<SugestaoFormula> list = sugestaoFormulaRespository.getSugestaoFormula(idativo);

		return new ResponseEntity<List<SugestaoFormula>>(list, HttpStatus.OK);

	}

}
