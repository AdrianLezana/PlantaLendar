package com.example.plantalendar.service;

import com.example.plantalendar.model.CalendarioRiego;
import com.example.plantalendar.model.Notificacion;
import com.example.plantalendar.repository.CalendarioRiegoRepository;
import com.example.plantalendar.repository.NotificacionRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Component
public class AlertaRiegoScheduler {

    private static final Map<DayOfWeek, String> DIAS_SEMANA = Map.of(
            DayOfWeek.MONDAY, "Lun",
            DayOfWeek.TUESDAY, "Mar",
            DayOfWeek.WEDNESDAY, "Mie",
            DayOfWeek.THURSDAY, "Jue",
            DayOfWeek.FRIDAY, "Vie",
            DayOfWeek.SATURDAY, "Sab",
            DayOfWeek.SUNDAY, "Dom"
    );

    private final CalendarioRiegoRepository calendarioRiegoRepository;
    private final NotificacionRepository notificacionRepository;

    public AlertaRiegoScheduler(CalendarioRiegoRepository calendarioRiegoRepository,
                                NotificacionRepository notificacionRepository) {
        this.calendarioRiegoRepository = calendarioRiegoRepository;
        this.notificacionRepository = notificacionRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void generarAlertasDeRiego() {
        LocalDateTime ahora = LocalDateTime.now();
        String diaActual = DIAS_SEMANA.get(ahora.toLocalDate().getDayOfWeek());
        LocalTime horaActual = ahora.toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        List<CalendarioRiego> calendariosActivos = calendarioRiegoRepository.findByActivoTrue();

        for (CalendarioRiego calendario : calendariosActivos) {
            LocalTime horaRiego = calendario.getHoraRiego();
            if (calendario.getDiasSemana() != null
                    && calendario.getDiasSemana().contains(diaActual)
                    && horaRiego != null
                    && horaRiego.truncatedTo(ChronoUnit.MINUTES).equals(horaActual)) {
                Notificacion notificacion = new Notificacion();
                notificacion.setTipoNotificacion("Alerta de Riego");
                notificacion.setMensaje("Es hora de regar según tu calendario de riego.");
                notificacion.setCalendario(calendario);
                notificacion.setUsuario(calendario.getUsuario());
                notificacion.setFechaHora(ahora);
                notificacion.setLeida(false);
                notificacionRepository.save(notificacion);
            }
        }
    }
}
