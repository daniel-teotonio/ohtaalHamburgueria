package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.ProdutosPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosPedidoRepository extends JpaRepository<ProdutosPedido, Integer> {

    List<ProdutosPedido> findProdutosPedidoByProdutoPedodo(ProdutosPedido produtoPedido);
}
