package br.com.zippydeliveryapi.model.enderecoCliente;

//import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.model.cliente.Cliente;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EnderecoCliente")
//@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCliente extends EntidadeAuditavel {

  @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;

    private String complemento;

}
