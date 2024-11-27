package br.com.ohtaalhamburgueria.model.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProdutoDTO(
        String nome,
        String descricao,
        BigDecimal preco,
        Categoria categoria
) {
    public record Categoria(
            Integer idCategoria
    ) {
    }
}

