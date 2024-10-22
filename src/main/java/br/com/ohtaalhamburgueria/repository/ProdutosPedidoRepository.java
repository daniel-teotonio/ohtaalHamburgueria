package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.ProdutosPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosPedidoRepository extends JpaRepository<ProdutosPedido, Integer> {

    List<ProdutosPedido> findProdutosPedidoByProdutoPedodo(ProdutosPedido produtoPedido);
}
