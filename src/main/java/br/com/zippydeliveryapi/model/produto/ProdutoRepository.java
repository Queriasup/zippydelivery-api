package br.com.zippydeliveryapi.model.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT c AS categoriaId, p FROM CategoriaProduto c LEFT JOIN Produto p ON c.id = p.categoriaId.id")
    List<Object[]> agruparPorCategoria();
    
}
