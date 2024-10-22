package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findItemByIdItem(Integer idItem);

}
