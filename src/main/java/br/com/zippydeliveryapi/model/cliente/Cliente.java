package br.com.zippydeliveryapi.model.cliente;

import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = false)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String senha;

    @Column
    private String logradouro;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column(length = 10)
    private String cep;

    @Column
    private String complemento;

}
