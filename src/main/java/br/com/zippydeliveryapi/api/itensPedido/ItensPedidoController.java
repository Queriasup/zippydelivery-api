package br.com.zippydeliveryapi.api.itensPedido;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zippydeliveryapi.model.itensPedido.ItensPedido;
import br.com.zippydeliveryapi.model.itensPedido.ItensPedidoService;

import br.com.zippydeliveryapi.model.pedido.PedidoService;
import br.com.zippydeliveryapi.model.produto.ProdutoService;
import jakarta.validation.Valid;

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

        
        System.out.println(itemPedidoNovo);
        itemPedidoNovo.setPedido(pedidoService.findById(request.getId_pedido()));
        
        itemPedidoNovo.setProduto(produtoService.findById(request.getId_produto()));

        ItensPedido itensPedido = itensPedidoService.save(itemPedidoNovo);

        return new ResponseEntity<ItensPedido>(itensPedido, HttpStatus.CREATED);
    }

}
