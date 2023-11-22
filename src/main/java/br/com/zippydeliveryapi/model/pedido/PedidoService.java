package br.com.zippydeliveryapi.model.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedidoRepository;
import br.com.zippydeliveryapi.util.exception.EntidadeNaoEncontradaException;
import javax.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;


    private List<ItensPedido> criaListaPedidos(Pedido pedido) {
        List<ItensPedido> itens = new ArrayList<ItensPedido>();

        for (ItensPedido item : pedido.getItensPedido()) {
            itens.add(item);
        }
        return itens;
    }
    //SOMAR A TAXA 
    private Double calcularValorTotalPedido(List<ItensPedido> itensPedidos){
        Double valorTotal = 0.0;

        for (ItensPedido itens : itensPedidos) {
            valorTotal += itens.getValorTotal();
        }
        return valorTotal;
    }

    @Transactional
    public Pedido save(Pedido novoPedido) {
        List<ItensPedido> itens = criaListaPedidos(novoPedido);
        novoPedido.setItensPedido(null);
        novoPedido.setDataHora(LocalDateTime.now());
        novoPedido.setStatusPagamento("Em aberto");
        novoPedido.setValorTotal(this.calcularValorTotalPedido(itens));
        novoPedido.setHabilitado(true);

        Pedido pedidoSalvo = repository.saveAndFlush(novoPedido);

        for (ItensPedido item : itens) {
            item.setPedido(pedidoSalvo);
            item.setHabilitado(true);
            itensPedidoRepository.saveAndFlush(item);
        }
        pedidoSalvo.setItensPedido(itens);
        return pedidoSalvo;
    }

    public List<Pedido> findAll() {
        //List<Pedido> pedidos = repository.findAll();
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, String statusPagamento, String statusPedido) {
        Pedido pedido = repository.findById(id).get();
        pedido.setStatusPedido(statusPedido);
        pedido.setStatusPagamento(statusPagamento);
        pedido.setVersao(pedido.getVersao() + 1);

        repository.save(pedido);
    }

    @Transactional
    public void delete(Long id) {
        Pedido pedido = repository.findById(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException("Pedido", id));

        pedido.setHabilitado(Boolean.FALSE);
        pedido.setVersao(pedido.getVersao() + 1);

        repository.save(pedido);
    }

}
