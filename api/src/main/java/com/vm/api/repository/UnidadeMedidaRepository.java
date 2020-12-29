package com.vm.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vm.api.model.UnidadeMedida;

@Repository
@Transactional
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long>{
	
	@Query("select u from UnidadeMedida u order by u.unidade asc")
	List<UnidadeMedida> findAllByOrderBy();

}
