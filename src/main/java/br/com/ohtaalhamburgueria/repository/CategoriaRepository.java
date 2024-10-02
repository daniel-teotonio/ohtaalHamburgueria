package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {

    Categoria findCategoriaByIdCategoria(Integer idCategoria);

}
