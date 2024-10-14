package com.equipos.gestion_equipos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.equipos.gestion_equipos.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
