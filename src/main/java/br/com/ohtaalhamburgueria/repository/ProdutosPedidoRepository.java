package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Produto;
import br.com.ohtaalhamburgueria.model.ProdutosPedido;
import br.com.ohtaalhamburgueria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosPedidoRepository extends JpaRepository<ProdutosPedido, Integer> {

    List<ProdutosPedido> findProdutosPedidoByProduto(Produto produto);
}
