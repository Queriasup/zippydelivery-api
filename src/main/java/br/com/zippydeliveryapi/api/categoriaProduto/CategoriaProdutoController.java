package br.com.zippydeliveryapi.api.categoriaProduto;

import java.util.List;

import jakarta.validation.Valid;

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


import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProduto;
import br.com.zippydeliveryapi.model.categoriaProduto.CategoriaProdutoService;



@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin
public class CategoriaProdutoController {

   @Autowired
   private CategoriaProdutoService categoriaProdutoService;

   @PostMapping
   public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

       CategoriaProduto categoriaProduto = request.build();
       CategoriaProduto categoriaProdutoNova = categoriaProdutoService.save(categoriaProduto);
       return new ResponseEntity<CategoriaProduto>(categoriaProdutoNova, HttpStatus.CREATED);
   }
 
     @GetMapping
    public List<CategoriaProduto> findAll() {
  
        return categoriaProdutoService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaProduto findById(@PathVariable Long id) {

        return categoriaProdutoService.findById(id);
    }

    @PutMapping("/{id}")
   public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {

       categoriaProdutoService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       categoriaProdutoService.delete(id);
       return ResponseEntity.ok().build();
   }
}
