package com.lp2.projeto_sistemacursos.service.serviceImplement;

import com.lp2.projeto_sistemacursos.model.Curso;
import com.lp2.projeto_sistemacursos.model.Professor;
import com.lp2.projeto_sistemacursos.repository.CursoRepository;
import com.lp2.projeto_sistemacursos.service.CursoService;
import com.lp2.projeto_sistemacursos.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoImplement implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(long id) {
        return cursoRepository.findById(id).get();
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
}
