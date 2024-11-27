package br.com.ohtaalhamburgueria.controller.request;

import java.math.BigDecimal;

public record ProdutoRequest(
        String nome,
        String descricao,
        BigDecimal preco,
        Integer idCategoria
) {
}
