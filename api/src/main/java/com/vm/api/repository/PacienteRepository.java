package com.vm.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.api.model.Paciente;

@Repository
@Transactional
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
