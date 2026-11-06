package com.example.plantalendar.controller;

import com.example.plantalendar.model.CalendarioRiego;
import com.example.plantalendar.repository.ConfiguracionInvernaderoRepository;
import com.example.plantalendar.repository.NotificacionRepository;
import com.example.plantalendar.repository.PerfilUsuarioRepository;
import com.example.plantalendar.service.CalendarioRiegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/calendario")
public class CalendarioRiegoController {

    private final CalendarioRiegoService calendarioRiegoService;
    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final ConfiguracionInvernaderoRepository configuracionInvernaderoRepository;
    private final NotificacionRepository notificacionRepository; // Añadido

    public CalendarioRiegoController(
            CalendarioRiegoService calendarioRiegoService,
            PerfilUsuarioRepository perfilUsuarioRepository,
            ConfiguracionInvernaderoRepository configuracionInvernaderoRepository,
            NotificacionRepository notificacionRepository) { // Añadido al constructor
        this.calendarioRiegoService = calendarioRiegoService;
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.configuracionInvernaderoRepository = configuracionInvernaderoRepository;
        this.notificacionRepository = notificacionRepository; // Inyectado
    }

    @GetMapping
    public String mostrarCalendario(Model model) {
        model.addAttribute("calendario", new CalendarioRiego());
        model.addAttribute("notificaciones", notificacionRepository.findAll());
        return "calendario";
    }

    @PostMapping
    public String guardarCalendario(@ModelAttribute CalendarioRiego calendario) {
        calendario.setUsuario(perfilUsuarioRepository.getReferenceById(
                UUID.fromString("67c377f0-c001-4704-97b3-fac87351f07e")));
        calendario.setConfiguracion(configuracionInvernaderoRepository.getReferenceById(1));
        calendarioRiegoService.guardarCalendario(calendario);
        return "redirect:/calendario?exito";
    }
}