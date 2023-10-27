package br.com.zippydeliveryapi.modelo.empresa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional
    public Empresa save(Empresa empresa){

        
       empresa.setHabilitado(Boolean.TRUE);
       empresa.setVersao(1L);
      empresa.setDataCriacao(LocalDate.now());
       return repository.save(empresa);



    }

    

    
}
