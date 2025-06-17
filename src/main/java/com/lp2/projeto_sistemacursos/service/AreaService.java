package com.lp2.projeto_sistemacursos.service;

import com.lp2.projeto_sistemacursos.model.Area;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AreaService {

    List<Area> findAll();
    Area findById(long id);
    Area save(Area area);
}
