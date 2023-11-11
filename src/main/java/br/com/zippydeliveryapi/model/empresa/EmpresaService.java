package br.com.zippydeliveryapi.model.empresa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zippydeliveryapi.model.acesso.UsuarioService;
import br.com.zippydeliveryapi.util.exception.EntidadeNaoEncontradaException;
import javax.transaction.Transactional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private UsuarioService usuarioService;


    @Transactional
    public Empresa save(Empresa empresa) {

        usuarioService.save(empresa.getUsuario());
        
        empresa.setHabilitado(Boolean.TRUE);
        empresa.setVersao(1L);
        empresa.setDataCriacao(LocalDate.now());
        return repository.save(empresa);
    }

    @Transactional
    public void update(Long id, Empresa empresaAlterado) {
        Empresa empresa = repository.findById(id).get();
        empresa.setNome(empresaAlterado.getNome());
        empresa.setEmail(empresaAlterado.getEmail());
        empresa.setCategoria(empresaAlterado.getCategoria());
        empresa.setTempoEntrega(empresaAlterado.getTempoEntrega());
        empresa.setTaxaFrete(empresaAlterado.getTaxaFrete());
        empresa.setTelefone(empresaAlterado.getTelefone());
        empresa.setImgPerfil(empresaAlterado.getImgPerfil());
        empresa.setImgCapa(empresaAlterado.getImgCapa());
        empresa.setNumeroEndereco(empresaAlterado.getNumeroEndereco());
        empresa.setBairro(empresaAlterado.getBairro());
        empresa.setCidade(empresaAlterado.getCidade());
        empresa.setComplemento(empresaAlterado.getComplemento());
        empresa.setLogradouro(empresaAlterado.getLogradouro());
        empresa.setEstado(empresaAlterado.getEstado());
        empresa.setCep(empresaAlterado.getCep());

        empresa.setVersao(empresa.getVersao() + 1);
        repository.save(empresa);
    }

    public List<Empresa> findAll() { 
        return repository.findAll(); 
    }

    public Empresa findById(Long id) {
        Optional<Empresa> consulta = repository.findById(id);

        if (consulta.isPresent()) {
            return consulta.get();
        } else {
            throw new EntidadeNaoEncontradaException("Empresa", id);
        }
    }

    @Transactional
    public void delete(Long id) {
        Empresa empresa = repository.findById(id).get();

        empresa.setHabilitado(Boolean.FALSE);
        empresa.setVersao(empresa.getVersao() + 1);
        empresa.setCnpj("");
        empresa.setEmail("");
        empresa.setTelefone("");

        repository.save(empresa);
    }

}
