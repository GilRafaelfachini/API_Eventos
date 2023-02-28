package br.com.API_Shows.demo.service.interfaces;

import br.com.API_Shows.demo.dto.EventoDto;

import java.util.List;

public interface IEventoCrudService {
    List<EventoDto> listEventos();
    EventoDto createEvento(EventoDto eventoCreateDto);
    void updateEvento(Long id, EventoDto eventoUpdateDto);
   EventoDto getEvento(Long id);
    void deleteEvento(Long id);
}
