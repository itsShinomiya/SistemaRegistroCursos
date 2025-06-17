package com.lp2.projeto_sistemacursos.service.serviceImplement;

import com.lp2.projeto_sistemacursos.model.Area;
import com.lp2.projeto_sistemacursos.repository.AreaRepository;
import com.lp2.projeto_sistemacursos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaImplement implements AreaService {

    @Autowired
    AreaRepository AreaRepository;

    @Override
    public List<Area> findAll() { return AreaRepository.findAll(); }

    @Override
    public Area findById(long id) { return AreaRepository.findById(id).get(); }

    @Override
    public Area save(Area area) { return AreaRepository.save(area); }
}
