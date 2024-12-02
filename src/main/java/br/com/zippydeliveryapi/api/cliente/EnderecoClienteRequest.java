package br.com.zippydeliveryapi.api.cliente;

import org.hibernate.validator.constraints.Length;

import br.com.zippydeliveryapi.model.enderecoCliente.EnderecoCliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoClienteRequest {

   @NotNull(message = "O Logradouro é de preenchimento obrigatório")
   @NotBlank(message = "O Logradouro é de preenchimento obrigatório")
   @Length(max = 255, message = "O Logradouro deverá ter no máximo {max} caracteres")
   private String logradouro;

   @NotNull(message = "O bairro é de preenchimento obrigatório")
   @NotBlank(message = "O bairro é de preenchimento obrigatório")
   private String bairro;

   @NotNull(message = "A cidade é de preenchimento obrigatório")
   @NotBlank(message = "A cidade é de preenchimento obrigatório")
   private String cidade;

   //@Length(max = 10, message = "O estado deverá ter no máximo {max} caracteres")
   @NotBlank(message = "O estado é de preenchimento obrigatório")
   private String estado;

   @NotBlank(message = "O cep é de preenchimento obrigatório")
   private String cep;

   private String complemento;

   public EnderecoCliente build() {
      return EnderecoCliente.builder()
            .logradouro(logradouro)
            .bairro(bairro)
            .cidade(cidade)
            .estado(estado)
            .cep(cep)
            .complemento(complemento)
            .build();
   }

}
