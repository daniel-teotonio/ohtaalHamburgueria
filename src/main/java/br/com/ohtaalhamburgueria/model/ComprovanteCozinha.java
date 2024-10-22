package br.com.ohtaalhamburgueria.model;

import br.com.ohtaalhamburgueria.model.Pedido;
import br.com.ohtaalhamburgueria.model.Produto;

public class ComprovanteCozinha {

    public static String gerarComprovante(Pedido pedido) {
        StringBuilder comprovante = new StringBuilder();
        comprovante.append("---- Pedido para a Cozinha ----\n");

        pedido.getProdutos().stream()
                .map(Produto::getNome)
                .distinct()
                .forEach(nome -> {
                    long quantidade = pedido.getProdutos().stream()
                            .filter(p -> p.getNome().equals(nome))
                            .count();
                    comprovante.append(quantidade).append("x ").append(nome).append("\n");
                });

        comprovante.append("-------------------------------\n");
        return comprovante.toString();
    }
}
