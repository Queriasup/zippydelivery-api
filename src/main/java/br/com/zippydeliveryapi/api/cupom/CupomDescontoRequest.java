package br.com.zippydeliveryapi.api.cupom;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.zippydeliveryapi.model.cupom.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CupomDescontoRequest {

  @NotNull(message = "O código do cupom é de preenchimento obrigatório")
  @NotBlank(message = "O código do cupom é de preenchimento obrigatório")
  @Length(max = 10, message = "O código deverá ter no máximo {max} caracteres")
  private String codigo;

  @NotNull(message = "O % de desconto é de preenchimento obrigatório")
  //@NotBlank(message = "O % de desconto é de preenchimento obrigatório")
  private Double percentualDesconto;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Past
  private LocalDate inicioVigencia;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Future
  private LocalDate fimVigencia;

  private Double valorDesconto;
  private Double valorMinimoPedidoPermitido;
  private Integer quantidadeMaximaUso;

  public CupomDesconto build() {

    return CupomDesconto.builder()
        .codigo(codigo)
        .percentualDesconto(percentualDesconto)
        .valorDesconto(valorDesconto)
        .valorMinimoPedidoPermitido(valorMinimoPedidoPermitido)
        .quantidadeMaximaUso(quantidadeMaximaUso)
        .inicioVigencia(inicioVigencia)
        .fimVigencia(fimVigencia)
        .build();
  }

}
