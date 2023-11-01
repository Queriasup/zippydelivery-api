package br.com.zippydeliveryapi.model.categoriaProduto;


import org.hibernate.annotations.Where;

import br.com.zippydeliveryapi.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategoriaProduto")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProduto extends EntidadeAuditavel {

    @Column
    private String descricao;


    
}
