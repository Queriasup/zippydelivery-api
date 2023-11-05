package br.com.zippydeliveryapi.model.produto;

// import java.util.ArrayList;
import java.util.Set;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
   @OneToMany(mappedBy = "produto")
   @JsonManagedReference
   private Set<ItensPedido> itensPedido;


   @Column
   private String titulo;

   @Column
   private String imagem;

   @Column
   private String descricao;

   @Column
   private Double preco;

   @Column
   private Boolean disponibilidade;

}
