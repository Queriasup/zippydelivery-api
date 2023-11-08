package br.com.zippydeliveryapi.model.produto;

import java.util.Set;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import javax.persistence.Column;
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
@Table(name = "Produto")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {

   @ManyToOne
   @JoinColumn(name = "categoria_id")
   private CategoriaProduto categoria;

   @Column
   @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
   @JsonManagedReference
   private Set<ItensPedido> itensPedido;

   @Column(nullable = false, length = 100)
   private String titulo;

   @Column(nullable = false)
   private String imagem;

   @Column
   private String descricao;

   @Column(nullable = false)
   private Double preco;

   @Column
   private Boolean disponibilidade;

}
