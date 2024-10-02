package br.com.ohtaalhamburgueria.model;


import br.com.ohtaalhamburgueria.model.Enums.TipoEntrega;
import br.com.ohtaalhamburgueria.model.Enums.TipoPagamento;
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
    private int id;

    @Column
    private String status;

    @Column
    private float valorTotal;

    @Enumerated(EnumType.STRING)
    private TipoEntrega tipoEntrega;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "PEDIDO_ENTITY", cascade = CascadeType.ALL)
    private List<Produto> produtos;

}
