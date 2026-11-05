package com.example.plantalendar.repository;

import com.example.plantalendar.model.CalendarioRiego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarioRiegoRepository extends JpaRepository<CalendarioRiego, Integer> {

    List<CalendarioRiego> findByActivoTrue();
}
