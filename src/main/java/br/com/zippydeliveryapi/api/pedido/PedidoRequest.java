package br.com.zippydeliveryapi.api.pedido;


import java.time.LocalDateTime;

import br.com.zippydeliveryapi.model.pedido.Pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

  
    private Long id_cliente;

    private Long id_empresa;

    private LocalDateTime dataHora;

   
    private String formaPagamento;

 
    private String statusPedido;

 
    private String statusPagamento;

 
    private Double valorTotal;

  
    private Double taxaEntrega;

    

    private String logradouro;

  
    private String bairro;

 
    private String cidade;


    private String estado;


    private String cep;


    private String complemento;


    private String numeroEndereco;


   public Pedido build() {
       return Pedido.builder()
               .dataHora(dataHora)
               .formaPagamento(formaPagamento)
               .statusPagamento(statusPagamento)
               .statusPedido(statusPedido)
               .taxaEntrega(taxaEntrega)
               .logradouro(logradouro)
               .bairro(bairro)
               .cidade(cidade)
               .estado(estado)
               .cep(cep)
               .complemento(complemento)
               .numeroEndereco(numeroEndereco)
               .build();
   }
}
