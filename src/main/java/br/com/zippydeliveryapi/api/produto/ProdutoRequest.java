package br.com.zippydeliveryapi.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.zippydeliveryapi.model.produto.Produto;
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
public class ProdutoRequest {

   @NotNull(message = "O Id da Categoria é de preenchimento obrigatório")
   private Long idCategoria;

   @NotNull(message = "O título é de preenchimento obrigatório")
   @NotBlank(message = "O título é de preenchimento obrigatório")
   @Length(max = 500, message = "O título deverá ter no máximo {max} caracteres")
   private String titulo;

   @NotNull(message = "A descrição é de preenchimento obrigatório")
   @NotBlank(message = "A descrição é de preenchimento obrigatório")
   @Length(max = 2000, message = "A descrição deverá ter no máximo {max} caracteres")
   private String descricao;

   @NotNull(message = "O preço é de preenchimento obrigatório")
   private Double preco;

   private String imagem;
   private Boolean disponibilidade;
   private Integer tempoEntregaMinimo;
   private Integer tempoEntregaMaximo;

   public Produto build() {
      return Produto.builder()
            .descricao(descricao)
            .imagem(imagem)
            .titulo(titulo)
            .disponibilidade(disponibilidade)
            .preco(preco)
            .build();
   }
}
