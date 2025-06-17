package com.lp2.projeto_sistemacursos.service;

import com.lp2.projeto_sistemacursos.model.Curso;
import com.lp2.projeto_sistemacursos.model.Professor;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();
    Curso findById(long id);
    Curso save(Curso curso);
}
