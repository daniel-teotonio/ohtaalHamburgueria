package br.com.ohtaalhamburgueria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "PRODUTO_ENTITY")
public class Produto {

    public Produto(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private BigDecimal preco;

    @OneToMany(mappedBy = "PRODUTO_ENTITY")
    private List<ProdutosPedido> produtosPedidos;
}
