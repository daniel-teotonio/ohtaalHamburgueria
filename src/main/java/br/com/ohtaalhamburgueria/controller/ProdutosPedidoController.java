package br.com.ohtaalhamburgueria.controller;

import br.com.ohtaalhamburgueria.model.ComprovanteCozinha;
import br.com.ohtaalhamburgueria.model.ComprovanteUsuario;
import br.com.ohtaalhamburgueria.model.Pedido;
import br.com.ohtaalhamburgueria.model.ProdutosPedido;
import br.com.ohtaalhamburgueria.service.PedidoService;
import br.com.ohtaalhamburgueria.service.ProdutosPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos-pedido")
public class ProdutosPedidoController {

    private final ProdutosPedidoService produtosPedidoService;
    private final PedidoService pedidoService;


    @Autowired
    public ProdutosPedidoController(ProdutosPedidoService produtosPedidoService, PedidoService pedidoService) {
        this.produtosPedidoService = produtosPedidoService;
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutosPedido>> getAllProdutosPedidos() {
        return new ResponseEntity<>(produtosPedidoService.getAllProdutosPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosPedido> getProdutosPedidoById(@PathVariable Integer id) {
        return new ResponseEntity<>(produtosPedidoService.getProdutosPedidoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutosPedido> createProdutosPedido(@RequestBody ProdutosPedido produtosPedido) {
        return new ResponseEntity<>(produtosPedidoService.createProdutosPedido(produtosPedido), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosPedido> updateProdutosPedido(@PathVariable Integer id, @RequestBody ProdutosPedido produtosPedido) {
        return new ResponseEntity<>(produtosPedidoService.updateProdutosPedido(produtosPedido), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutosPedido(@PathVariable Integer id) {
        produtosPedidoService.deleteProdutosPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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