package br.com.ohtaalhamburgueria.controller;
import br.com.ohtaalhamburgueria.model.ComprovanteCozinha;
import br.com.ohtaalhamburgueria.model.ComprovanteUsuario;
import br.com.ohtaalhamburgueria.model.Pedido;
import br.com.ohtaalhamburgueria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido createdPedido = pedidoService.createPedido(pedido);
        return new ResponseEntity<>(createdPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
        return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
    }

    @ DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}/comprovante-cliente")
    public ResponseEntity<String> gerarComprovanteCliente(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);

        if (pedido.isPresent()) {
            String comprovanteCliente = ComprovanteUsuario.gerarComprovante(pedido.get());
            return new ResponseEntity<>(comprovanteCliente, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/comprovante-cozinha")
    public ResponseEntity<String> gerarComprovanteCozinha(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);

        if (pedido.isPresent()) {
            String comprovanteCozinha = ComprovanteCozinha.gerarComprovante(pedido.get());
            return new ResponseEntity<>(comprovanteCozinha, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}