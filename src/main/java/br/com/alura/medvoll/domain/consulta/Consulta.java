package br.com.alura.medvoll.domain.consulta;

import br.com.alura.medvoll.domain.medico.Medico;
import br.com.alura.medvoll.domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Consulta") @Table(name = "consultas")
@Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Consulta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private LocalDateTime data;
    @Column(name = "motivo_cancelamento") @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;


    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}
