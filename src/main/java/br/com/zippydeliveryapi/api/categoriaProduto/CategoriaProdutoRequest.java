package br.com.zippydeliveryapi.api.categoriaProduto;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

    private String descricao;

    private Long empresa_id;
    
     public CategoriaProduto build() {
      
       return CategoriaProduto.builder()
               .descricao(descricao)
               .build();
   }
}
