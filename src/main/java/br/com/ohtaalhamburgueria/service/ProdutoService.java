package br.com.ohtaalhamburgueria.service;

import br.com.ohtaalhamburgueria.controller.request.ProdutoRequest;
import br.com.ohtaalhamburgueria.model.Categoria;
import br.com.ohtaalhamburgueria.model.Produto;
import br.com.ohtaalhamburgueria.model.dto.ProdutoDTO;
import br.com.ohtaalhamburgueria.repository.CategoriaRepository;
import br.com.ohtaalhamburgueria.repository.ProdutoRepository;
import br.com.ohtaalhamburgueria.service.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper produtoMapper;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.toProduto(produtoDTO);

        Categoria categoriaEntity = categoriaRepository
                .findByIdCategoria(produto.getCategoria().getIdCategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoria Inválida!"));

        produto.setCategoria(categoriaEntity);

        Produto savedProduto = produtoRepository.save(produto);

        return produtoMapper.toProdutoDTO(savedProduto);

    }

    public Produto updateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Integer id) {
        produtoRepository.deleteById(id);
    }
}
