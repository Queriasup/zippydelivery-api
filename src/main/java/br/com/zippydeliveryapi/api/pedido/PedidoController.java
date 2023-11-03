package br.com.zippydeliveryapi.api.pedido;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zippydeliveryapi.model.cliente.ClienteService;

import br.com.zippydeliveryapi.model.empresa.EmpresaService;

import br.com.zippydeliveryapi.model.pedido.Pedido;
import br.com.zippydeliveryapi.model.pedido.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody @Valid PedidoRequest request) {
        Pedido pedidoNovo = request.build();
        System.out.println(request);
        pedidoNovo.setCliente(clienteService.findById(request.getId_cliente()));
        
        pedidoNovo.setEmpresa(empresaService.findById(request.getId_empresa()));
        Pedido pedido = pedidoService.save(pedidoNovo);

        return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
    }

    

}
