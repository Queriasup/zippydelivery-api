package br.com.zippydeliveryapi.api.cliente;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.zippydeliveryapi.model.acesso.Usuario;
import br.com.zippydeliveryapi.model.cliente.Cliente;
import br.com.zippydeliveryapi.model.enderecoCliente.EnderecoCliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Email;
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

   @Length(max = 10, message = "O CEP deverá ter no máximo {max} caracteres")
   private String cep;

   @NotBlank(message = "A senha é de preenchimento obrigatório")
   private String senha;

   @Builder.Default
   private List<EnderecoCliente> enderecos = new ArrayList<EnderecoCliente>();

   public Cliente build() {
      return Cliente.builder()
      .usuario(buildUsuario())
            .nome(nome)
            .cpf(cpf)
            .email(email)
            .senha(senha)
            .enderecos(enderecos)
            .build();
   }

  public Usuario buildUsuario() {
	
	return Usuario.builder()
		.username(email)
		.password(senha)
		.roles(Arrays.asList(Usuario.ROLE_CLIENTE))
		.build();
    }


}
