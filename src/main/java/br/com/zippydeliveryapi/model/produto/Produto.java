package br.com.zippydeliveryapi.model.produto;

import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
