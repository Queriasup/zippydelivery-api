package br.com.zippydeliveryapi.api.empresa;

import org.hibernate.validator.constraints.Length;

import br.com.zippydeliveryapi.model.empresa.Empresa;
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
public class EmpresaRequest {

    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 500, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    @NotNull(message = "O CNPJ é de preenchimento obrigatório")
    @NotBlank(message = "O CNPJ é de preenchimento obrigatório")
    @Length(max = 20, message = "CNPJ out of range, too long")
    private String cnpj;

    @NotNull(message = "O Email é de preenchimento obrigatório")
    @NotBlank(message = "O Email é de preenchimento obrigatório")
    @Email
    private String email;

    @NotNull(message = "O CEP é de preenchimento obrigatório")
    @NotBlank(message = "O CEP é de preenchimento obrigatório")
    @Length(max = 10, message = "O CEP deverá ter no máximo {max} caracteres")
    private String cep;

    private String categoria;
    private Integer tempoEntrega;
    private Double taxaFrete;
    private String telefone;
    private String imgPerfil;
    private String imgCapa;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numeroEndereco;

    public Empresa build() {
        return Empresa.builder()
                .nome(nome)
                .cnpj(cnpj)
                .email(email)
                .categoria(categoria)
                .tempoEntrega(tempoEntrega)
                .taxaFrete(taxaFrete)
                .telefone(telefone)
                .imgPerfil(imgPerfil)
                .imgCapa(imgCapa)
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
