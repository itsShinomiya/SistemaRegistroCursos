package com.lp2.projeto_sistemacursos.repository;

import com.lp2.projeto_sistemacursos.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

}
