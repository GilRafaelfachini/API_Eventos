package br.com.API_Shows.demo.service;

import br.com.API_Shows.demo.dto.EventoDto;
import br.com.API_Shows.demo.model.Evento;
import br.com.API_Shows.demo.repository.EventoRepository;
import br.com.API_Shows.demo.service.interfaces.IEventoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EventoCrudCrudService implements IEventoCrudService {
   @Autowired
    private EventoRepository eventoRepository;

    public EventoDto createEvento(EventoDto eventoDto) {
        Evento evento = new Evento();
        evento.setNome(eventoCreateDto.getNome());
        evento = repository.save(evento);

        EventoDto eventoDto = new EventoDto(evento);
        return eventoDto;
    }
    public List<EventoDto> listEventos() {
        List<EventoDto> eventosDtos = new ArrayList<EventoDto>();
        List<Evento> eventos = repository.findAll();

        for (Evento evento : eventos) {
            EventoDto eventoDto = new EventoDto(evento);
            eventoDto.add(eventoDto);
        }

        return eventosDtos;
    }
    public void updateEvento(Long id, EventoDto eventoDto) {

        Optional<Evento> eventoOptional = this.repository.findById(id);

        if (eventoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }

        Evento evento = eventoOptional.get();
        evento.setNome(eventoDto.getNome());
        this.repository.save(aluno);
    }

    public EventoDto getEvento(Long id) {

        Optional<Evento> eventoOptional = this.repository.findById(id);

        if (eventoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }
        Evento evento = eventoOptional.get();
        EventoDto eventoDto = new EventoDto(evento);
        return eventoDto;
    }

    public void deleteEvento(Long id) {

        Optional<Evento> eventoOptional = this.repository.findById(id);

        if (eventoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador não encontrado. Id:" + id); //retorna NotFound ('Não encontrado para a url');
        }
        Evento evento = eventoOptional.get();
        this.repository.delete(evento);
    }
}
