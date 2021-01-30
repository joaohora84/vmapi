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
	
	@Query("select a from Ativo a where lower(a.nome) like lower(concat(?1, '%')) order by a.nome asc")
	List<Ativo> getAtivoByName(String nome);
	
	@Query(value="select * from Ativo order by idativo desc limit 5", nativeQuery = true)
	List<Ativo> getAtivoNovo();
	
	@Query(value = "select * from ativo as a\n"
			+ "	left join ativo_especialidades as e\n"
			+ "	on a.idativo = e.ativo_idativo\n" + ""
			+ "	where e.especialidades_idespecialidade = :idespecialidade order by a.nome asc", nativeQuery = true)
	List<Ativo> getAtivoByEspecialidade(Long idespecialidade);

	@Query(value = "select * from ativo as a\n" 
	        + "	left join ativo_especialidades as e\n"
			+ "	on a.idativo = e.ativo_idativo\n"
	        + "	where e.especialidades_idespecialidade = :idespecialidade "
			+ " and lower(a.nome) like lower(:nome || '%') order by a.nome asc", nativeQuery = true)
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
