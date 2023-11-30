package br.com.zippydeliveryapi.model.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import br.com.zippydeliveryapi.model.acesso.Usuario;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByUsuario(Optional<Usuario> usuario);
  
}