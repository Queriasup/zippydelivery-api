package br.com.zippydeliveryapi.model.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.model.acesso.Usuario;
import br.com.zippydeliveryapi.model.acesso.UsuarioService;
import br.com.zippydeliveryapi.model.enderecoCliente.EnderecoCliente;
import br.com.zippydeliveryapi.model.enderecoCliente.EnderecoClienteRepository;
import br.com.zippydeliveryapi.model.mensagens.EmailService;
import br.com.zippydeliveryapi.util.exception.EntidadeNaoEncontradaException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EnderecoClienteRepository enderecoRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        usuarioService.save(cliente.getUsuario());

        cliente.setHabilitado(Boolean.TRUE);
        cliente.setVersao(1L);
        cliente.setDataCriacao(LocalDate.now());
        Cliente clienteSalvo = repository.save(cliente);
 
        emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);
 
        return clienteSalvo;
    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente", id));

        /*if (clienteAlterado.getBairro() == null) {
            cliente.setNome(clienteAlterado.getNome());
            cliente.setEmail(clienteAlterado.getEmail());
            cliente.setSenha(clienteAlterado.getSenha());
            cliente.setLogradouro(cliente.getLogradouro());
            cliente.setBairro(cliente.getBairro());
            cliente.setCidade(cliente.getCidade());
            cliente.setEstado(cliente.getEstado());
            cliente.setCep(cliente.getCep());
            cliente.setComplemento(cliente.getComplemento());
            cliente.getUsuario().setUsername(clienteAlterado.getEmail());
        } else {
            cliente.setNome(cliente.getNome());
            cliente.setEmail(cliente.getEmail());
            cliente.setLogradouro(clienteAlterado.getLogradouro());
            cliente.setBairro(clienteAlterado.getBairro());
            cliente.setCidade(clienteAlterado.getCidade());
            cliente.setEstado(clienteAlterado.getEstado());
            cliente.setCep(clienteAlterado.getCep());
            cliente.setComplemento(clienteAlterado.getComplemento());
        }*/

        cliente.setVersao(cliente.getVersao() + 1);
        repository.save(cliente);
    }


    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findByUsuario(Long id) {

        Optional<Usuario> usuario = usuarioService.find(id);

        return repository.findByUsuario(usuario);
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
        cliente.getUsuario().setUsername("");
        cliente.getUsuario().setPassword("");

        repository.save(cliente);
    }

    @Transactional
    public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoCliente endereco) {
 
        Cliente cliente = repository.findById(clienteId).get();
       
        //Primeiro salva o EnderecoCliente:
        endereco.setCliente(cliente);
        endereco.setHabilitado(Boolean.TRUE);
        enderecoRepository.save(endereco);
       
        //Depois acrescenta o endereço criado ao cliente e atualiza o cliente:
        List<EnderecoCliente> listaEnderecoCliente = cliente.getEnderecos();
       
        if (listaEnderecoCliente == null) {
            listaEnderecoCliente = new ArrayList<EnderecoCliente>();
        }
       
        listaEnderecoCliente.add(endereco);
        cliente.setEnderecos(listaEnderecoCliente);
        cliente.setVersao(cliente.getVersao() + 1);
        repository.save(cliente);
       
        return endereco;
    }

    @Transactional
    public EnderecoCliente atualizarEnderecoCliente(Long clienteId, EnderecoCliente enderecoAlterado) {

       EnderecoCliente endereco = enderecoRepository.findById(clienteId).get();
       endereco.setLogradouro(enderecoAlterado.getLogradouro());
       endereco.setBairro(enderecoAlterado.getBairro());
       endereco.setCidade(enderecoAlterado.getCidade());
       endereco.setEstado(enderecoAlterado.getEstado());
       endereco.setCep(enderecoAlterado.getCep());
       endereco.setComplemento(enderecoAlterado.getComplemento());
       return enderecoRepository.save(endereco);
   }

   @Transactional
    public void removerEnderecoCliente(Long clienteId) {

    EnderecoCliente endereco = enderecoRepository.findById(clienteId).get();
    endereco.setHabilitado(Boolean.FALSE);
    enderecoRepository.save(endereco);

    Cliente cliente = this.findById(endereco.getCliente().getId());
    cliente.getEnderecos().remove(endereco);
           cliente.setVersao(cliente.getVersao() + 1);
    repository.save(cliente);
}

}
