package com.vm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vm.api.model.FormaFamaceutica;

@Repository
@Transactional
public interface FormaFarmaceuticaRepository extends JpaRepository<FormaFamaceutica, Long>{

}
