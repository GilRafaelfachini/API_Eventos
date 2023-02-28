package br.com.API_Shows.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
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
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long codigo;
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

   /* @AssertTrue(message = "A data do evento não pode ser inferior à data de criação.")
    public boolean isDataEventoMaiorQueDataCriacao() {
        return dataDoEvento == null || dataDeCriacao == null || !dataDoEvento.before(dataDeCriacao);
    }
    @PreUpdate
    public void preUpdate () {
        Evento eventoOriginal = EntityManagerProvider.getEntityManager().find(Evento.class, Long id);
        if (!eventoOriginal.getNome().equals(nome)) {
            throw new RuntimeException("Não é possível editar o nome do evento.");
        }
        if (!eventoOriginal.getDataCriacao().equals(dataCriacao)) {
            throw new RuntimeException("Não é possível editar a data de criação do evento.");
        }
    }*/
}
