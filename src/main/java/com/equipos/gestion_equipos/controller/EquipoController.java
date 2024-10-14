package com.equipos.gestion_equipos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.equipos.gestion_equipos.model.Equipo;
import com.equipos.gestion_equipos.model.Estado;
import com.equipos.gestion_equipos.service.EquipoService; // Asegúrate de importar el servicio

@Controller
public class EquipoController {

    @Autowired
    private EquipoService equipoService; // Usa el servicio en lugar del repositorio directamente

    @GetMapping("/equipos")
    public String listarEquipos(Model model) {
        List<Equipo> equipos = equipoService.obtenerTodosLosEquipos();
        model.addAttribute("equipos", equipos);
        return "equipos"; // Asegúrate de que este nombre coincide con el archivo equipos.html
    }

    @PostMapping("/equipos/guardar")
    public String guardarEquipo(Equipo equipo) {
        equipo.setEstado(Estado.FUNCIONANDO); // Establecer estado por defecto
        equipoService.guardarEquipo(equipo);
        return "redirect:/equipos"; 
    }

    @PostMapping("/equipos/actualizar")
    public String actualizarEstado(@RequestParam("id") Long id, 
                                    @RequestParam("estado") Estado estado,
                                    RedirectAttributes redirectAttributes) {
        equipoService.actualizarEstado(id, estado);
        // Añadir un mensaje de éxito
        redirectAttributes.addFlashAttribute("mensaje", "Estado actualizado con éxito");
        return "redirect:/equipos";
    }

    @GetMapping("/test")
    @ResponseBody
    public String testEndpoint() {
        return "Test exitoso!";
    }
}
