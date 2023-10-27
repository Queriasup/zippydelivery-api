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

   
    private String senha;

    
    private String email;

  
     private String horario;

   
    
    private String categoria;

    
    private String img_capa;

   
    private String tempo_entrega;

    
    private String taxa_frete;

    
    private String telefone;

    
    private String img_perfil;



   public Empresa build() {

       return Empresa.builder()
               .nome(nome)
               .cnpj(cnpj)
               .senha(senha)
               .email(email)
               .horario(horario)
                .categoria(categoria)
               .img_capa(img_capa)
               .tempo_entrega(tempo_entrega)
               .taxa_frete(taxa_frete)
               .telefone(telefone)
                .img_perfil(img_perfil)
               .build();
   }
}



    

