package br.com.zippydeliveryapi.model.cliente;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.zippydeliveryapi.model.acesso.Usuario;
import br.com.zippydeliveryapi.model.enderecoCliente.EnderecoCliente;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

  
  @ManyToOne
   @JoinColumn(nullable = false)
   private Usuario usuario;

    //@Column(nullable = false, length = 100)
    private String nome;

    //@Column(unique = false)
    private String cpf;

    //@Column(nullable = false, unique = true)
    private String email;

    //@Column(nullable = false, unique = true)
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EnderecoCliente> enderecos;

}
