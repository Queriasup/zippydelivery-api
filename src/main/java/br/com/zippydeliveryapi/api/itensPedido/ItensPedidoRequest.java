package br.com.zippydeliveryapi.api.itensPedido;

import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItensPedidoRequest {

    private Long id_produto;

    private Long id_pedido;

    private Integer qtdProduto;
  
    private Double valorUnitario;
 


   public ItensPedido build() {
       return ItensPedido.builder()
               .qtdProduto(qtdProduto)
               .valorUnitario(valorUnitario)           
               .build();
   }
}

