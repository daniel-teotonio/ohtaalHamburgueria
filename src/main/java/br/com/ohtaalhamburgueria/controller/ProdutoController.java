package br.com.ohtaalhamburgueria.controller;

import br.com.ohtaalhamburgueria.controller.request.ProdutoRequest;
import br.com.ohtaalhamburgueria.model.Produto;
import br.com.ohtaalhamburgueria.model.dto.ProdutoDTO;
import br.com.ohtaalhamburgueria.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        return new ResponseEntity<>(produtoService.getAllProdutos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        return new ResponseEntity<>(produtoService.getProdutoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO request) {
        return new ResponseEntity<>(produtoService.createProduto(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.updateProduto(produto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}