package com.cursoMinchelli.eventosApp.repository;

import com.cursoMinchelli.eventosApp.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
