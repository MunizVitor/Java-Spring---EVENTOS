package com.cursoMinchelli.eventosApp.repository;

import com.cursoMinchelli.eventosApp.model.Convidado;
import com.cursoMinchelli.eventosApp.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {
    Iterable<Convidado> findByEvento(Evento evento);
}
