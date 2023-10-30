package br.com.zippydeliveryapi.model.produto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        if(produto.getDisponibilidade() == false){
            throw new ProdutoException(ProdutoException.MSG_DISPONIBILIDADE_PRODUTO);
        }
        produto.setHabilitado(Boolean.TRUE);
        produto.setVersao(1L);
        produto.setDataCriacao(LocalDate.now());
        return repository.save(produto);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Produto update(Long id, Produto produtoAlterado) {
        Produto produto = repository.findById(id).get();

        produto.setCategoria(produtoAlterado.getCategoria());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setImagem(produtoAlterado.getImagem());
        produto.setPreco(produtoAlterado.getPreco());
        produto.setDisponibilidade(produtoAlterado.getDisponibilidade());
        produto.setVersao(produto.getVersao() + 1);

        return repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = repository.findById(id).get();

        produto.setHabilitado(Boolean.FALSE);
        produto.setVersao(produto.getVersao() + 1);

        repository.save(produto);
    }

}
