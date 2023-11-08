package br.com.zippydeliveryapi.api.itensPedido;

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

import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedidoService;
import br.com.zippydeliveryapi.model.pedido.PedidoService;
import br.com.zippydeliveryapi.model.produto.ProdutoService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/itenspedido")
@CrossOrigin
public class ItensPedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItensPedidoService itensPedidoService;


    @PostMapping
    public ResponseEntity<ItensPedido> save(@RequestBody @Valid ItensPedidoRequest request) {
        ItensPedido itemPedidoNovo = request.build();

        itemPedidoNovo.setPedido(pedidoService.findById(request.getId_pedido()));
        itemPedidoNovo.setProduto(produtoService.findById(request.getId_produto()));
        ItensPedido itensPedido = itensPedidoService.save(itemPedidoNovo);

        return new ResponseEntity<ItensPedido>(itensPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ItensPedido> findAll() {
        return itensPedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ItensPedido findById(@PathVariable Long id) {
        return itensPedidoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensPedido> update(@PathVariable("id") Long id, @RequestBody ItensPedidoRequest request) {
       itensPedidoService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       itensPedidoService.delete(id);
       return ResponseEntity.ok().build();
   }

}
