package br.com.zippydeliveryapi.model.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.com.zippydeliveryapi.model.acesso.Usuario;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByUsuario(Usuario usuario);
  
}