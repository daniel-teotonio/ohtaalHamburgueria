package br.com.ohtaalhamburgueria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "CATEGORIA_ENTITY")
public class Categoria {

    public Categoria() {super();    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;

    @Column
    private String nome;

    @OneToMany(mappedBy = "CATEGORIA_ENTITY", cascade = CascadeType.ALL)
    private List<Produto> produtos;

}
