package br.com.zippydeliveryapi.api.cliente;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zippydeliveryapi.model.cliente.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

   @NotNull(message = "O Nome é de preenchimento obrigatório")
   @NotBlank(message = "O Nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
   private String nome;

   @NotNull(message = "O CPF é de preenchimento obrigatório")
   @NotBlank(message = "O CPF é de preenchimento obrigatório")
   @CPF
   private String cpf;

   @NotNull(message = "O Email é de preenchimento obrigatório")
   @NotBlank(message = "O Email é de preenchimento obrigatório")
   @Email
   private String email;

   @NotNull(message = "O CEP é de preenchimento obrigatório")
   @NotBlank(message = "O CEP é de preenchimento obrigatório")
   @Length(max = 10, message = "O Nome deverá ter no máximo {max} caracteres")
   private String cep;

   private String senha;
   private String logradouro;
   private String bairro;
   private String cidade;
   private String estado;
   private String complemento;

   public Cliente build() {
      return Cliente.builder()
            .nome(nome)
            .cpf(cpf)
            .email(email)
            .senha(senha)
            .logradouro(logradouro)
            .bairro(bairro)
            .cidade(cidade)
            .estado(estado)
            .cep(cep)
            .complemento(complemento)
            .build();
   }
}