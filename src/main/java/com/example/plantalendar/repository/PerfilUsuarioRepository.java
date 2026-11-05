package com.example.plantalendar.repository;

import com.example.plantalendar.model.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, UUID> {
}
