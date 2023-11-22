package br.com.zippydeliveryapi.model.empresa;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.api.empresa.EmpresaRequest;
import br.com.zippydeliveryapi.model.acesso.Usuario;
import br.com.zippydeliveryapi.model.categoria.CategoriaEmpresa;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Empresa")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {

  @ManyToOne
  @JoinColumn(nullable = false)
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "idCategoria")
  private CategoriaEmpresa categoria;

  // @Column(nullable = false, length = 100)
  private String nome;

  // @Column(unique = true)
  private String cnpj;

  @Column(nullable = false, unique = true)
  private String email;

  @Column
  private Integer tempoEntrega;

  @Column
  private Double taxaFrete;

  @Column
  private String telefone;

  @Column
  private String imgPerfil;

  @Column
  private String imgCapa;

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

  @Column
  private String status;

  public static Empresa fromRequest(EmpresaRequest request, CategoriaEmpresa categoria) {
    Usuario usuario = Usuario.builder()
        .roles(Arrays.asList(Usuario.ROLE_EMPRESA))
        .username(request.getEmail())
        .password(request.getSenha())
        .build();

    return Empresa.builder()
        .nome(request.getNome())
        .cnpj(request.getCnpj())
        .email(request.getEmail())
        .usuario(usuario)
        .categoria(categoria)
        .tempoEntrega(request.getTempoEntrega())
        .taxaFrete(request.getTaxaFrete())
        .telefone(request.getTelefone())
        .imgPerfil(request.getImgPerfil())
        .imgCapa(request.getImgCapa())
        .logradouro(request.getLogradouro())
        .bairro(request.getBairro())
        .cidade(request.getCidade())
        .estado(request.getEstado())
        .cep(request.getCep())
        .complemento(request.getComplemento())
        .numeroEndereco(request.getNumeroEndereco())
        .build();
  }

}
