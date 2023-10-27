package br.com.zippydeliveryapi.model.cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.util.exception.EntidadeNaoEncontradaException;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    @Transactional
    public Cliente save(Cliente cliente) {
       
        cliente.setHabilitado(Boolean.TRUE);
        cliente.setVersao(1L);
        cliente.setDataCriacao(LocalDate.now());
       
        return repository.save(cliente);

    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {

        Cliente cliente = repository.findById(id).get();
        cliente.setNome(clienteAlterado.getNome());
        cliente.setEmail(clienteAlterado.getEmail());
        cliente.setLogradouro(clienteAlterado.getLogradouro());
        cliente.setBairro(clienteAlterado.getBairro());
        cliente.setCidade(clienteAlterado.getCidade());
        cliente.setEstado(clienteAlterado.getEstado());
        cliente.setCep(clienteAlterado.getCep());
        cliente.setComplemento(clienteAlterado.getComplemento());
        
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
        cliente.setCpf("");
        cliente.setEmail("");
        cliente.setVersao(cliente.getVersao() + 1);

        repository.save(cliente);
    }


}
