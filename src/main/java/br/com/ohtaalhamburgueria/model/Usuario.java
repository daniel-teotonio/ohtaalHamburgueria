package br.com.ohtaalhamburgueria.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "USER_ENTITY")
public class Usuario {

    public Usuario() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String nome;

    @Column
    String endereco;

    @Column
    String telefone;

    @Column
    String email;

    @OneToMany(mappedBy = "USER_ENTITY", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pedido> pedidos;

}
