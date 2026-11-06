package com.example.plantalendar.service;

import com.example.plantalendar.model.CalendarioRiego;
import com.example.plantalendar.model.Notificacion;
import com.example.plantalendar.repository.CalendarioRiegoRepository;
import com.example.plantalendar.repository.NotificacionRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class AlertaRiegoScheduler {

    private final CalendarioRiegoRepository calendarioRiegoRepository;
    private final NotificacionRepository notificacionRepository;

    public AlertaRiegoScheduler(CalendarioRiegoRepository calendarioRiegoRepository, NotificacionRepository notificacionRepository) {
        this.calendarioRiegoRepository = calendarioRiegoRepository;
        this.notificacionRepository = notificacionRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void verificarRiegosProgramados() {
        List<CalendarioRiego> activos = calendarioRiegoRepository.findByActivoTrue();
        if (activos.isEmpty()) return;

        // 1. Forzar la hora a minutos exactos (ej. 16:45:00) para igualar a PostgreSQL
        LocalTime horaActual = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);

        // 2. Mapear el día actual al formato exacto de los checkboxes del HTML
        String[] diasHtml = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int diaActualInt = LocalDate.now().getDayOfWeek().getValue();
        String diaHoy = diasHtml[diaActualInt];

        System.out.println("Cron Check: Buscando riegos para " + diaHoy + " a las " + horaActual);

        for (CalendarioRiego cal : activos) {
            // Validación estricta, previniendo nulos
            if (cal.getHoraRiego() != null && cal.getDiasSemana() != null) {
                if (cal.getHoraRiego().equals(horaActual) && cal.getDiasSemana().contains(diaHoy)) {

                    Notificacion notif = new Notificacion();
                    notif.setTipoNotificacion("Alerta de Riego");
                    notif.setMensaje("Riego automático activado para Sector Orquídeas Demo");
                    notif.setUsuario(cal.getUsuario());
                    notif.setCalendario(cal);
                    notif.setLeida(false);
                    notif.setFechaHora(LocalDateTime.now());

                    notificacionRepository.save(notif);
                    System.out.println(">>> ÉXITO: Notificación guardada en la base de datos.");
                }
            }
        }
    }
}