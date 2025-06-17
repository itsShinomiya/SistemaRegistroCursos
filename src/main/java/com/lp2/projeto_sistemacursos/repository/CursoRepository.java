package com.lp2.projeto_sistemacursos.repository;

import com.lp2.projeto_sistemacursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursoRepository extends JpaRepository<Curso, Long> {

}
