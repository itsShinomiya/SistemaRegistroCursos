package com.lp2.projeto_sistemacursos.service;

import org.springframework.stereotype.Service;
import com.lp2.projeto_sistemacursos.model.Professor;

import java.util.List;

public interface ProfService {

    List<Professor> findAll();
    Professor findById(long id);
    Professor save(Professor professor);

}
