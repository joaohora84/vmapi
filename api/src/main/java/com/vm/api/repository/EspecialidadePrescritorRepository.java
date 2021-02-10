package com.vm.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vm.api.model.EspecialidadePrescritor;

@Repository
@Transactional
public interface EspecialidadePrescritorRepository extends JpaRepository<EspecialidadePrescritor, Long> {

	@Query("select e from EspecialidadePrescritor e order by e.nome asc")
	List<EspecialidadePrescritor> findAllByOrderBy();

	@Query(value = "select * from especialidade_prescritor as e " + "where lower(e.nome) "
			+ "like lower(:nome || '%') order by e.nome asc ", nativeQuery = true)
	List<EspecialidadePrescritor> getEspecialidadePorNome(String nome);

}
