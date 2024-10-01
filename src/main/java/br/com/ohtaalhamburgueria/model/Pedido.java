package br.com.ohtaalhamburgueria.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "PEDIDO_ENTITY")
public class Pedido {

    public Pedido() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String status;

    @Column
    float valorTotal;

    @Column
    String tipoRecebimento;

    @Column
    String tipoPagamento;

    @Column
    String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    Usuario usuario;

}
