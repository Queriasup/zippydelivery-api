package br.com.zippydeliveryapi.model.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //List<Cliente> findByCpfContainingIgnoreCase(String cpf);

  
}