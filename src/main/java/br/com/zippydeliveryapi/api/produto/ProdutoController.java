package br.com.zippydeliveryapi.api.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProdutoService;
import br.com.zippydeliveryapi.model.produto.Produto;
import br.com.zippydeliveryapi.model.produto.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {
        Produto produtoNovo = request.build();

        produtoNovo.setCategoria(categoriaProdutoService.findById(request.getIdCategoria()));
        Produto produto = produtoService.save(produtoNovo);

        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {
        Produto produtoNovo = request.build();

        produtoNovo.setId(id);
        produtoNovo.setCategoria(categoriaProdutoService.findById(request.getIdCategoria()));
        produtoService.update(id, produtoNovo);

        return new ResponseEntity<Produto>(produtoNovo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
