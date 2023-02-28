package br.com.API_Shows.demo.controller;

import br.com.API_Shows.demo.dto.EventoDto;
import br.com.API_Shows.demo.service.interfaces.IEventoCrudService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController()
@RequestMapping("/eventos")
public class EventoController {

    private IEventoCrudService eventoCrudService;
    public EventoController(IEventoCrudService alunoCrudService) {

        this.eventoCrudService = alunoCrudService;
    }
    
    @PostMapping("/eventos")
    public EventoDto createEvento(@RequestBody EventoDto eventoDto) {
        return this.eventoCrudService.createEvento(eventoDto);
    }

    @GetMapping("/eventos")
    public List<EventoDto> listEventos() {
        return this.eventoCrudService.listEventos();
    }

    @PutMapping("/alunos/{id}")
    public void updateEvento(@PathVariable Long id, @RequestBody EventoDto eventoDto) {
        this.eventoCrudService.updateEvento(id, eventoDto);
    }

    @GetMapping("/alunos/{id}")
    public EventoDto getEvento(@PathVariable Long id) {
        return this.eventoCrudService.getEvento(id);
    }


    @DeleteMapping("/alunos/{id}")
    public void deleteEvento(@PathVariable Long id) {
        this.eventoCrudService.deleteEvento(id);
    }

}