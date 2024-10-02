package br.com.ohtaalhamburgueria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "CAREGORIA_ENTITY")
public class Categoria {

    public Categoria() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCategoria;

    @Column
    String nomeCategoria;

    @OneToMany(mappedBy = "CAREGORIA_ENTITY", cascade = CascadeType.ALL)
    List<Produto> produtos;

}
