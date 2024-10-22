package br.com.ohtaalhamburgueria.model;

import br.com.ohtaalhamburgueria.model.Pedido;
import br.com.ohtaalhamburgueria.model.Produto;

public class ComprovanteUsuario {

    public static String gerarComprovante(Pedido pedido) {
        StringBuilder comprovante = new StringBuilder();
        comprovante.append("---- Comprovante do Cliente ----\n");
        comprovante.append("Cliente: ").append(pedido.getUsuario().getNome()).append("\n");
        comprovante.append("Endereço de Entrega: ").append(pedido.getUsuario().getEndereco()).append("\n");
        comprovante.append("Tipo de Entrega: ").append(pedido.getTipoEntrega()).append("\n");
        comprovante.append("Tipo de Pagamento: ").append(pedido.getTipoPagamento()).append("\n");
        comprovante.append("Itens do Pedido:\n");

        for (Produto produto : pedido.getProdutos()) {
            comprovante.append("- ").append(produto.getNome()).append(": R$").append(produto.getPreco()).append("\n");
            comprovante.append("  Descrição: ").append(produto.getDescricao()).append("\n");
        }

        comprovante.append("Total: R$").append(pedido.getValorTotal()).append("\n");
        comprovante.append("-------------------------------\n");

        return comprovante.toString();
    }
}
