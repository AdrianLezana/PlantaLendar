package com.example.plantalendar.service;

import com.example.plantalendar.model.CalendarioRiego;
import com.example.plantalendar.repository.CalendarioRiegoRepository;
import org.springframework.stereotype.Service;

@Service
public class CalendarioRiegoService {

    private final CalendarioRiegoRepository calendarioRiegoRepository;

    public CalendarioRiegoService(CalendarioRiegoRepository calendarioRiegoRepository) {
        this.calendarioRiegoRepository = calendarioRiegoRepository;
    }

    public CalendarioRiego guardarCalendario(CalendarioRiego calendario) {
        return calendarioRiegoRepository.save(calendario);
    }
}
