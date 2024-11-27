package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Produto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Override
    @EntityGraph(attributePaths = {"categoria"})
    List<Produto> findAll();
}
