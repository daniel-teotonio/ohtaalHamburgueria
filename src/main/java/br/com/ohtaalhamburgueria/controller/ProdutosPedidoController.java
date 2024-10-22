package br.com.ohtaalhamburgueria.controller;

import br.com.ohtaalhamburgueria.model.ProdutosPedido;
import br.com.ohtaalhamburgueria.service.ProdutosPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos-pedido")
public class ProdutosPedidoController {

    private final ProdutosPedidoService produtosPedidoService;

    @Autowired
    public ProdutosPedidoController(ProdutosPedidoService produtosPedidoService) {
        this.produtosPedidoService = produtosPedidoService;
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
}