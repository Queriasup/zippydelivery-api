package br.com.zippydeliveryapi.model.produto;




import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
