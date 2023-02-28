package br.com.API_Shows.demo.dto;

import br.com.API_Shows.demo.model.Evento;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {
    @Size(min = 5, max = 30, message = "Campo deve ter entre 5 e 30 caracteres")
    @Column(nullable = false,unique = true)
    private String nomeDoEvento;
    @Size(min = 5, max = 30, message = "Campo deve ter entre 5 e 30 caracteres")
    @Column(nullable = false,unique = true)
    private String nomeDoPatrocinador;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,unique = true)
    @DateTimeFormat(pattern = "yyyy - MM - dd")
    private Date dataDoEvento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,unique = true)
    @DateTimeFormat(pattern = "yyyy - MM - dd")
    private Date dataDeCriacao;

    @Column(nullable = false,unique = true)
    private String local;
    @Size(min = 5, max = 30, message = "Campo deve ter entre 5 e 30 caracteres")
    @Column(nullable = false,unique = true)
    private String nomeDoArtista;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false,unique = true)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date horarioDoInicio;

    @Column(nullable = false,unique = true)
    @Max(value = 300, message = "A duração máxima do evento é de 5 horas.")
    private Integer duracao; // minutos
    @Column(nullable = false,unique = true)
    private Integer lotacaoMaxima;

    public EventoDto(Evento evento) {
        this.nomeDoEvento = evento.getNomeDoEvento();
        this.nomeDoPatrocinador =evento.getNomeDoPatrocinador();
        this.dataDoEvento =evento.getDataDoEvento();
        this.dataDeCriacao =evento.getDataDeCriacao();
        this.local = evento.getLocal();
        this.nomeDoArtista =evento.getNomeDoArtista();
        this.horarioDoInicio =evento.getHorarioDoInicio();
        this.duracao = evento.getDuracao();
        this.lotacaoMaxima =evento.getLotacaoMaxima();
    }
}
