package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findPedidoByUsuario(Integer id);
}
