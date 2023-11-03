package br.com.zippydeliveryapi.model.pedido;

import java.time.LocalDate;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @jakarta.transaction.Transactional
    public Pedido save(Pedido pedido) {

        pedido.setHabilitado(Boolean.TRUE);
        pedido.setVersao(1L);
        pedido.setDataCriacao(LocalDate.now());
        return repository.save(pedido);
    }

    public List<Pedido> findAll() {

        return repository.findAll();
    }

    public Pedido findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Pedido pedidoAlterado) {

        Pedido pedido = repository.findById(id).get();
        pedido.setCliente(pedidoAlterado.getCliente());
        pedido.setDataHora(pedidoAlterado.getDataHora());
        pedido.setEmpresa(pedidoAlterado.getEmpresa());
        pedido.setFormaPagamento(pedidoAlterado.getFormaPagamento());
        pedido.setStatusPagamento(pedidoAlterado.getStatusPagamento());
        pedido.setStatusPedido(pedidoAlterado.getStatusPedido());
        pedido.setTaxaEntrega(pedidoAlterado.getTaxaEntrega());
        pedido.setValorTotal(pedidoAlterado.getValorTotal());
        pedido.setNumeroEndereco(pedidoAlterado.getNumeroEndereco());
        pedido.setBairro(pedidoAlterado.getBairro());
        pedido.setCidade(pedidoAlterado.getCidade());
        pedido.setComplemento(pedidoAlterado.getComplemento());
        pedido.setLogradouro(pedidoAlterado.getLogradouro());
        pedido.setEstado(pedidoAlterado.getEstado());
        pedido.setCep(pedidoAlterado.getCep());
        pedido.setVersao(pedidoAlterado.getVersao() + 1);
        repository.save(pedido);
    }

    @Transactional
    public void delete(Long id) {
        Pedido pedido = repository.findById(id).get();
        pedido.setHabilitado(Boolean.FALSE);
        pedido.setVersao(pedido.getVersao() + 1);

        repository.save(pedido);
    }

   
}
