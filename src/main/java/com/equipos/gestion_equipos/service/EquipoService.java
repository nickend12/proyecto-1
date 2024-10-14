package com.equipos.gestion_equipos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipos.gestion_equipos.model.Equipo;
import com.equipos.gestion_equipos.model.Estado;
import com.equipos.gestion_equipos.repository.EquipoRepository;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    public void guardarEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    public Equipo obtenerEquipoPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public void actualizarEstado(Long id, Estado estado) {
        Equipo equipo = equipoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado"));
        equipo.setEstado(estado);
        equipoRepository.save(equipo);
    }
}
