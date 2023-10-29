package br.com.zippydeliveryapi.model.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Empresa")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true)
    private String cnpj;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String categoria;

    @Column
    private String horario;

    @Column
    private Integer tempoEntrega;

    @Column
    private Double taxaFrete;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column
    private String imgPerfil;

    @Column
    private String imgCapa;

}
