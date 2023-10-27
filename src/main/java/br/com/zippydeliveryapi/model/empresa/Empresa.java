package br.com.zippydeliveryapi.model.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Empresa")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel{


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
