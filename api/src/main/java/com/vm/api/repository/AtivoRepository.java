package com.vm.api.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vm.api.model.Ativo;

@Repository
@Transactional
public interface AtivoRepository extends JpaRepository<Ativo, Long> {
	
	int limit = 2;
	
	@Query("select a from Ativo a where a.especialidade.id= ?1")
	List<Ativo> getAtivoPorEspecialide(Long especialidade);
	
	@Query("select a from Ativo a where lower(a.nome) like lower(concat(?1, '%'))")
	List<Ativo> getAtivoByName(String nome);
	
	@Query(value="select * from Ativo order by idativo desc limit 5", nativeQuery = true)
	List<Ativo> getAtivoNovo();
	
	@Query("select a from Ativo a where a.especialidade.id= ?1")
	List<Ativo> getAtivoByEspecialidade(Long idespecialidade);

	@Query("select a from Ativo a where a.especialidade.id= ?1 and lower(a.nome) like lower(concat(?2, '%'))")
	List<Ativo> getAtivoByEspecialidadeNome(Long idespecialidade, String nome);

	default Page<Ativo> findAtivoByNamePage(String nome, Pageable pageable) {

		Ativo ativo = new Ativo();
		ativo.setNome(nome);

		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny().withMatcher("nome",
				ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

		Example<Ativo> example = Example.of(ativo, ignoringExampleMatcher);

		Page<Ativo> ativos = findAll(example, pageable);

		return ativos;

	}

}
