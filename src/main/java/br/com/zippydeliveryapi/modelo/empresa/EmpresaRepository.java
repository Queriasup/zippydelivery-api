package br.com.zippydeliveryapi.modelo.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
    
}
