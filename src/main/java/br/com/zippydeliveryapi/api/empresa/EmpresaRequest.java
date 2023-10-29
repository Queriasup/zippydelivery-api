package br.com.zippydeliveryapi.api.empresa;

import br.com.zippydeliveryapi.model.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmpresaRequest {

    private String nome;

    private String cnpj;

    private String email;

    private String categoria;

    private String horario;

    private Integer tempoEntrega;

    private Double taxaFrete;

    private String telefone;

    private String imgPerfil;

    private String imgCapa;

    public Empresa build() {

        return Empresa.builder()
                .nome(nome)
                .cnpj(cnpj)
                .email(email)
                .categoria(categoria)
                .horario(horario)
                .tempoEntrega(tempoEntrega)
                .taxaFrete(taxaFrete)
                .telefone(telefone)
                .imgPerfil(imgPerfil)
                .imgCapa(imgCapa)
                .build();
    }
}
