package br.com.zippydeliveryapi.model.produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import br.com.zippydeliveryapi.util.exception.ProdutoException;
import javax.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @javax.transaction.Transactional
    public Produto save(Produto produto) {
        if (produto.getDisponibilidade() == false) {
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
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setCategoria(produtoAlterado.getCategoria());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setImagem(produtoAlterado.getImagem());
        produto.setPreco(produtoAlterado.getPreco());
        produto.setDisponibilidade(produtoAlterado.getDisponibilidade());
        produto.setVersao(produto.getVersao() + 1);
        repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);
        produto.setVersao(produto.getVersao() + 1);

        repository.save(produto);
    }

    public List<List<Object>> agruparPorCategoria() {
        List<Object[]> resultados = repository.agruparPorCategoria();
        Map<Long, List<Object>> categoriasMap = new HashMap<>();

        for (Object[] resultado : resultados) {
            CategoriaProduto categoria = (CategoriaProduto) resultado[0];
            Object produto = resultado[1];

            if (produto != null) {
                categoriasMap.computeIfAbsent(categoria.getId(), k -> new ArrayList<>()).add(produto);
            }
        }

        return new ArrayList<>(categoriasMap.values());
    }

}
