package br.com.zippydeliveryapi.model.itensPedido;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.zippydeliveryapi.model.pedido.Pedido;
import br.com.zippydeliveryapi.model.produto.Produto;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ItensPedido")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItensPedido extends EntidadeAuditavel {

  
    @ManyToOne()
    @JoinColumn(name = "id_produto")
    @JsonBackReference
    private Produto produto;

  
    @ManyToOne()
    @JoinColumn(name = "id_pedido")
    @JsonBackReference
    private Pedido pedido;

    @Column
    private Integer qtdProduto;

    @Column
    private Double valorUnitario;

    @Column
    private Double valorTotal;

}

