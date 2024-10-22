package br.com.ohtaalhamburgueria.model;

import br.com.ohtaalhamburgueria.model.Enums.TipoEntrega;
import br.com.ohtaalhamburgueria.model.Enums.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "PEDIDO_USUARIO")
public class PedidoUsuario {

    public PedidoUsuario() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "tipoPagamento_id")
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "tipoEntrega_id")
    private TipoEntrega tipoEntrega;

    @Column
    private BigDecimal precoTotal;

}
