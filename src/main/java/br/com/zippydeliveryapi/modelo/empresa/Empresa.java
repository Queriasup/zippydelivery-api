package br.com.zippydeliveryapi.modelo.empresa;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Empresa")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel{

   @ManyToOne
   @JoinColumn(nullable = false)
   private Empresa empresa;

     @Column 
     private String nome;

   
    @Column 
    private String cnpj;

    @Column
    private String senha;

    @Column
    private String email;

     @Column 
     private String horario;

   
    @Column 
    private String categoria;

    @Column
    private String img_capa;

    @Column
    private String tempo_entrega;

    @Column 
    private String taxa_frete;

    @Column
    private String telefone;

    @Column
    private String img_perfil;


    
}
