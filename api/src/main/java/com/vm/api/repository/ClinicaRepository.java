package com.vm.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vm.api.model.Clinica;

@Repository
@Transactional
public interface ClinicaRepository extends JpaRepository<Clinica, Long>{
	
	@Query("select c from Clinica c where c.nome like %?1%")
	List<Clinica> findClinicaByName(String nome);
	
	default Page<Clinica> findClinicaByNamePage(String nome, Pageable pageable) {
		
		Clinica clinica = new Clinica();
		clinica.setNome(nome);
		
		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
			      .withMatcher("nome", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		Example<Clinica> example = Example.of(clinica, ignoringExampleMatcher);
		
		Page<Clinica> clinicas = findAll(example, pageable);
		
		return clinicas;
		
	}

}
