package br.com.zippydeliveryapi.model.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    @Query(value = "SELECT p FROM Pedido p WHERE p.cliente.id = :idCliente")
    List<Pedido> filtrarPedidosPorCliente(Long idCliente);

}

