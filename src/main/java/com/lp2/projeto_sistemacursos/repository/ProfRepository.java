package com.lp2.projeto_sistemacursos.repository;

import com.lp2.projeto_sistemacursos.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfRepository extends JpaRepository<Professor, Long> {

}
