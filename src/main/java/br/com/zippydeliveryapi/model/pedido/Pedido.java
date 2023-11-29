package br.com.zippydeliveryapi.model.pedido;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import lombok.*;
import br.com.zippydeliveryapi.model.cliente.Cliente;
import br.com.zippydeliveryapi.model.empresa.Empresa;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;

@Entity
@Table(name = "Pedido")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido extends EntidadeAuditavel {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @Column
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ItensPedido> itensPedido;

    @Column
    private LocalDateTime dataHora;

    @Column
    private String formaPagamento;

    @Column
    private String statusPedido;

    @Column
    private String statusPagamento;

    @Column
    private Double valorTotal;

    @Column 
    private Double taxaEntrega;

    @Column
    private String logradouro;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String estado;

   // @Column(nullable = false, length = 10)
    private String cep;

    @Column
    private String complemento;

    @Column
    private String numeroEndereco;

}
