package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findProdutoByIdProduto(Integer id);
}
