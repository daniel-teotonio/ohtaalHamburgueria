package br.com.ohtaalhamburgueria.model.Enums;

import lombok.Getter;

@Getter
public enum TipoPagamento {

    CARTAO(""),
    DINEHIRO(""),
    PIX("");

    private final String descricao;

    TipoPagamento(String descricao) {
        this.descricao = descricao;
    }
}
