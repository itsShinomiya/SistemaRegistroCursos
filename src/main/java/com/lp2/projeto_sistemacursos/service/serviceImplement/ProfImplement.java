package com.lp2.projeto_sistemacursos.service.serviceImplement;

import com.lp2.projeto_sistemacursos.model.Professor;
import com.lp2.projeto_sistemacursos.repository.ProfRepository;
import com.lp2.projeto_sistemacursos.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfImplement implements ProfService {

    @Autowired
    ProfRepository profRepository;

    @Override
    public List<Professor> findAll() {
        return profRepository.findAll();
    }

    @Override
    public Professor findById(long id) {
        return profRepository.findById(id).get();
    }

    @Override
    public Professor save(Professor professor) {
        return profRepository.save(professor);
    }
}
