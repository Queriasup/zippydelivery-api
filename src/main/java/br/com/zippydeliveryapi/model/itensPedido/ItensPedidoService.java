package br.com.zippydeliveryapi.model.itensPedido;

import java.time.LocalDate;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ItensPedidoService {

    @Autowired
    private ItensPedidoRepository repository;

    @jakarta.transaction.Transactional
    public ItensPedido save(ItensPedido itensPedido) {

        itensPedido.setHabilitado(Boolean.TRUE);
        itensPedido.setVersao(1L);
        itensPedido.setDataCriacao(LocalDate.now());
        return repository.save(itensPedido);
    }

    public List<ItensPedido> findAll() {

        return repository.findAll();
    }

    public ItensPedido findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, ItensPedido itensPedidoAlterado) {

        ItensPedido itensPedido = repository.findById(id).get();
        itensPedido.setProduto(itensPedidoAlterado.getProduto());
        itensPedido.setPedido(itensPedidoAlterado.getPedido());
        itensPedido.setQtdProduto(itensPedido.getQtdProduto());
        itensPedido.setValorTotal(itensPedidoAlterado.getValorTotal());
        itensPedido.setValorUnitario(itensPedidoAlterado.getValorUnitario());
        
        repository.save(itensPedido);
    }

    @Transactional
    public void delete(Long id) {
        ItensPedido itensPedido = repository.findById(id).get();
        itensPedido.setHabilitado(Boolean.FALSE);
        itensPedido.setVersao(itensPedido.getVersao() + 1);

        repository.save(itensPedido);
    }

   
}
