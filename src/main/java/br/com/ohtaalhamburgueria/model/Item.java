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
@Entity(name = "ITEM_ENTITY")
public class Item {

    public Item(){ super();  }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private BigDecimal preco;

}