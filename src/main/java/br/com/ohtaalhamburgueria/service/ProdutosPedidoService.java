//package br.com.ohtaalhamburgueria.service;
//
//import br.com.ohtaalhamburgueria.repository.ProdutosPedidoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProdutosPedidoService {
//
//    private final ProdutosPedidoRepository produtosPedidoRepository;
//
//    @Autowired
//    public ProdutosPedidoService(ProdutosPedidoRepository produtosPedidoRepository) {
//        this.produtosPedidoRepository = produtosPedidoRepository;
//    }
//
//    public List<ProdutosPedido> getAllProdutosPedidos() {
//        return produtosPedidoRepository.findAll();
//    }
//
//    public ProdutosPedido getProdutosPedidoById(Integer id) {
//        return produtosPedidoRepository.findById(id).orElse(null);
//    }
//
//    public ProdutosPedido createProdutosPedido(ProdutosPedido produtosPedido) {
//        return produtosPedidoRepository.save(produtosPedido);
//    }
//
//    public ProdutosPedido updateProdutosPedido(ProdutosPedido produtosPedido) {
//        return produtosPedidoRepository.save(produtosPedido);
//    }
//
//    public void deleteProdutosPedido(Integer id) {
//        produtosPedidoRepository.deleteById(id);
//    }
//}