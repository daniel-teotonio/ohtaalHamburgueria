package br.com.ohtaalhamburgueria.service;

import br.com.ohtaalhamburgueria.model.Pedido;
import br.com.ohtaalhamburgueria.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoService {


    private final PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Integer id, Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}