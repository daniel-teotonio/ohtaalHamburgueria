package br.com.ohtaalhamburgueria.model.Enums;

import lombok.Getter;

@Getter
public enum TipoEntrega {

    RETIRAR(""),
    ENTREGA("");

    private final String descricao;

    TipoEntrega(String descricao) {
        this.descricao = descricao;

    }

}
