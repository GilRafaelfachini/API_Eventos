package br.com.API_Shows.demo.repository;

import br.com.API_Shows.demo.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {
}
