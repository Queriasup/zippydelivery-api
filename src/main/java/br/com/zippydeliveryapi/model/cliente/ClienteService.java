package br.com.zippydeliveryapi.model.cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.model.acesso.UsuarioService;
import br.com.zippydeliveryapi.util.exception.EntidadeNaoEncontradaException;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
private UsuarioService usuarioService;

    
    @Transactional
    public Cliente save(Cliente cliente) {
        usuarioService.save(cliente.getUsuario());

        cliente.setHabilitado(Boolean.TRUE);
        cliente.setVersao(1L);
        cliente.setDataCriacao(LocalDate.now());
       
        return repository.save(cliente);

    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
        Cliente cliente = repository.findById(id).get();

        if (clienteAlterado.getBairro() == null) {

            cliente.setNome(clienteAlterado.getNome());
            cliente.setEmail(clienteAlterado.getEmail());
            cliente.setSenha(clienteAlterado.getSenha());
            cliente.setLogradouro(cliente.getLogradouro());
            cliente.setBairro(cliente.getBairro());
            cliente.setCidade(cliente.getCidade());
            cliente.setEstado(cliente.getEstado());
            cliente.setCep(cliente.getCep());
            cliente.setComplemento(cliente.getComplemento());
        } else {
            cliente.setNome(cliente.getNome());
            cliente.setEmail(cliente.getEmail());
            cliente.setLogradouro(clienteAlterado.getLogradouro());
            cliente.setBairro(clienteAlterado.getBairro());
            cliente.setCidade(clienteAlterado.getCidade());
            cliente.setEstado(clienteAlterado.getEstado());
            cliente.setCep(clienteAlterado.getCep());
            cliente.setComplemento(clienteAlterado.getComplemento());
        }

        cliente.setVersao(cliente.getVersao() + 1);
        repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> consulta = repository.findById(id);

        if (consulta.isPresent()) {
            return consulta.get();
        } else {
            throw new EntidadeNaoEncontradaException("Cliente", id);
        }

    }

    @Transactional
    public void delete(Long id) {
        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);
        cliente.setVersao(cliente.getVersao() + 1);
        cliente.setCpf("");
        cliente.setEmail("");

        repository.save(cliente);
    }


}
