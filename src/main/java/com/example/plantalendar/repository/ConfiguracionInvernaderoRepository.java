package com.example.plantalendar.repository;

import com.example.plantalendar.model.ConfiguracionInvernadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionInvernaderoRepository extends JpaRepository<ConfiguracionInvernadero, Integer> {
}
